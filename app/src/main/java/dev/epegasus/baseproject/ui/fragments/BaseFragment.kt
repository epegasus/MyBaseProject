package dev.epegasus.baseproject.ui.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dev.epegasus.baseproject.helper.di.DIComponent
import dev.epegasus.baseproject.helper.extensions.AttributesExtensions.getColorFromAttr
import dev.epegasus.baseproject.ui.activities.MainActivity

@SuppressLint("SourceLockedOrientationActivity")
open class BaseFragment<T : ViewDataBinding> : Fragment() {

    private var _binding: T? = null
    val binding get() = _binding!!

    val globalContext by lazy { binding.root.context }
    val globalActivity by lazy { globalContext as Activity }
    val mainActivity by lazy { globalActivity as MainActivity }

    val diComponent = DIComponent()
    var defaultTextColor = 0

    fun getView(inflater: LayoutInflater, container: ViewGroup?, layout: Int): View {
        _binding = DataBindingUtil.inflate(inflater, layout, container, false)
        initializations()
        return binding.root
    }

    private fun initializations() {
        defaultTextColor = getColorFromAttr(androidx.appcompat.R.attr.colorControlNormal)
    }

    fun lockRotation() {
        globalActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun unlockRotation() {
        val str: Int = Settings.System.getInt(globalContext.contentResolver, Settings.System.ACCELEROMETER_ROTATION, 0)
        if (str == 1) {
            globalActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        } else {
            globalActivity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            // rotation is Locked
        }
    }

    fun showKeyboard() {
        val imm: InputMethodManager? = globalContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun hideKeyboard() {
        val inputMethodManager: InputMethodManager = globalContext.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = globalActivity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}