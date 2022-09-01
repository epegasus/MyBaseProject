package dev.epegasus.baseproject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.databinding.FragmentSplashBinding
import dev.epegasus.baseproject.helper.extensions.FragmentExtensions.navigateTo
import dev.epegasus.baseproject.helper.remoteConfig.RemoteConfiguration
import dev.epegasus.baseproject.helper.utils.GeneralUtils.withDelay

class FragmentSplash : BaseFragment<FragmentSplashBinding>() {

    private val remoteConfiguration by lazy { RemoteConfiguration(globalContext, diComponent) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return getView(inflater, container, R.layout.fragment_splash)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        remoteConfiguration.checkRemoteConfig {
            // Completion Listener (either success or failure)
            withDelay(1000) { navigateTo(R.id.fragmentSplash, R.id.action_fragmentSplash_to_fragmentHome) }
        }
    }

}