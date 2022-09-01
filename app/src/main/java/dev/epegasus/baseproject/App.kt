package dev.epegasus.baseproject

import android.app.Application
import dev.epegasus.baseproject.helper.dataProviders.DPHomeFeatures
import dev.epegasus.baseproject.helper.managers.InternetManager
import dev.epegasus.baseproject.helper.utils.SharedPreferenceUtils
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { modules(listOf(generalModules, dataProviderModules, managerModules)) }
    }

    private val generalModules = module {
        single { SharedPreferenceUtils(applicationContext) }
    }

    private val dataProviderModules = module {
        single { DPHomeFeatures(applicationContext) }
    }

    private val managerModules = module {
        single { InternetManager(applicationContext) }
    }

    /*
    private val viewModelsModule = module {
         viewModel { CustomViewModel(getContext()) }
     }

     private val ads = module {
         single { InterstitialAdsConfig(activity) }
     }*/

}