package dev.epegasus.baseproject.helper.dataProviders

import android.content.Context
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.helper.models.HomeFeature
import dev.epegasus.baseproject.helper.utils.GeneralUtils.getString

class DPHomeFeatures(private val context: Context) {

    fun getHomeFeaturesList(): List<HomeFeature> {
        val arrayList = ArrayList<HomeFeature>().apply {
            add(HomeFeature(0, R.drawable.ic_dummy, getString(context, R.string.home_feature_1)))
            add(HomeFeature(1, R.drawable.ic_dummy, getString(context, R.string.home_feature_2)))
            add(HomeFeature(2, R.drawable.ic_dummy, getString(context, R.string.home_feature_3)))
            add(HomeFeature(3, R.drawable.ic_dummy, getString(context, R.string.home_feature_4)))
        }
        return arrayList.toList()
    }
}