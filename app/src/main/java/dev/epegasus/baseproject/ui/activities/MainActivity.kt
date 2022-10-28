package dev.epegasus.baseproject.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.databinding.ActivityMainBinding
import dev.epegasus.baseproject.helper.extensions.ActivityExtensions.hideSystemUI
import dev.epegasus.baseproject.helper.extensions.ActivityExtensions.onBackPressedDispatcher
import dev.epegasus.baseproject.helper.extensions.ActivityExtensions.showSystemUI

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initNavController()
        registerBackPress()
        initNavListener()
    }

    private fun initNavController() {
        navController = (supportFragmentManager.findFragmentById(binding.fcvContainerMain.id) as NavHostFragment).navController
    }

    private fun initNavListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentSplash ->
                    hideSystemUI(binding.fcvContainerMain)
                else ->
                    showSystemUI()
            }
        }
    }

    private fun registerBackPress() {
        onBackPressedDispatcher {
            when (navController.currentDestination?.id) {
                R.id.fragmentHome -> navController.navigate(R.id.action_fragmentHome_to_exitDialog)
                else -> finishAndRemoveTask()
            }
        }
    }
}