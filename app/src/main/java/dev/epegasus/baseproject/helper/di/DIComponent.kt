package dev.epegasus.baseproject.helper.di

import dev.epegasus.baseproject.helper.dataProviders.DPHomeFeatures
import dev.epegasus.baseproject.helper.managers.InternetManager
import dev.epegasus.baseproject.helper.utils.SharedPreferenceUtils
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DIComponent : KoinComponent {

    // Utils
    val sharedPreferenceUtils by inject<SharedPreferenceUtils>()

    // DataProviders
    val dpHomeFeatures by inject<DPHomeFeatures>()

    // Managers
    val internetManager by inject<InternetManager>()

}