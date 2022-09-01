package dev.epegasus.baseproject.helper.extensions

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.WindowCompat

object ActivityExtensions {

    fun Activity.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    @Suppress("DEPRECATION")
    fun Activity.hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            val controller = window.insetsController
            controller?.hide(WindowInsets.Type.ime())
            controller?.hide(WindowInsets.Type.systemBars())
            controller?.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        } else {
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }
    }

    @Suppress("DEPRECATION")
    fun Activity.showStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowCompat.setDecorFitsSystemWindows(window, true)
            val controller = window.insetsController
            controller?.show(WindowInsets.Type.systemBars())
        } else {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_VISIBLE)
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }
}