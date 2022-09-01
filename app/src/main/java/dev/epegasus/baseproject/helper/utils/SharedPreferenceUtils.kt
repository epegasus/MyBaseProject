package dev.epegasus.baseproject.helper.utils

import android.app.Application
import android.content.Context

class SharedPreferenceUtils(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(PREF_NAME, Application.MODE_PRIVATE)

    companion object {
        const val PREF_NAME = "app_preferences"
    }

    // Billing
    private val isBillingRequireKey = "isBillingRequire"

    // Remote Config
    private val dummyConfig = "dummyConfig"


    /* --------------------------------------------------------- Billing --------------------------------------------------------- */

    var isBillingRequired: Boolean
        get() = sharedPreferences.getBoolean(isBillingRequireKey, true)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(isBillingRequireKey, value)
                apply()
            }
        }

    /* ------------------------------------------------------ Remote Config ------------------------------------------------------ */

    var rcDummyConfig: Int
        get() = sharedPreferences.getInt(dummyConfig, 0)
        set(value) {
            sharedPreferences.edit().apply {
                putInt(dummyConfig, value)
                apply()
            }
        }
}