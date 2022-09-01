package dev.epegasus.baseproject.helper.remoteConfig

import android.content.Context
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.helper.di.DIComponent
import dev.epegasus.baseproject.helper.utils.LogUtils.showLog
import dev.epegasus.baseproject.helper.utils.LogUtils.showRemoteConfigLog

class RemoteConfiguration(private val context: Context, private val diComponent: DIComponent) {

    private val dummyConfig = "dummyConfig"

    fun checkRemoteConfig(callback: () -> Unit) {
        if (diComponent.internetManager.isInternetConnected) {
            val remoteConfig = Firebase.remoteConfig
            val configSettings = remoteConfigSettings { minimumFetchIntervalInSeconds = 2 }
            remoteConfig.setConfigSettingsAsync(configSettings)
            remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
            fetchRemoteValues(callback)
        } else {
            showLog(context, "checkRemoteConfig", "else", "Internet Not Found!")
            callback.invoke()
        }
    }

    private fun fetchRemoteValues(callback: () -> Unit) {
        val remoteConfig = Firebase.remoteConfig
        remoteConfig.fetchAndActivate().addOnCompleteListener { updateRemoteValues(callback) }
    }

    private fun updateRemoteValues(callback: () -> Unit) {
        val remoteConfig = Firebase.remoteConfig

        // Save this value anywhere
        diComponent.sharedPreferenceUtils.apply {
            rcDummyConfig = remoteConfig[dummyConfig].asLong().toInt()
        }
        showRemoteConfigLog(context, "updateRemoteValues", "rcInterLanguage", "${remoteConfig[dummyConfig].asLong().toInt()}")

        showLog(context, "updateRemoteValues", "Completion", "Fetched Successfully")
        callback.invoke()
    }
}