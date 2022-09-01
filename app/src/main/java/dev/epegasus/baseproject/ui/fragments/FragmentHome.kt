package dev.epegasus.baseproject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.databinding.FragmentHomeBinding
import dev.epegasus.baseproject.helper.adapters.recyclerView.AdapterHomeFeature
import dev.epegasus.baseproject.helper.extensions.FragmentExtensions.showToast
import dev.epegasus.baseproject.helper.interfaces.OnHomeFeatureClickListener
import dev.epegasus.baseproject.helper.itemDecorator.MarginItemDecoration
import dev.epegasus.baseproject.helper.models.HomeFeature

class FragmentHome : BaseFragment<FragmentHomeBinding>() {

    private lateinit var adapterHomeFeature: AdapterHomeFeature

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return getView(inflater, container, R.layout.fragment_home)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapterHomeFeature = AdapterHomeFeature(object : OnHomeFeatureClickListener {
            override fun onHomeFeatureClick(homeFeature: HomeFeature) {
                showToast(homeFeature.title)
            }
        })
        binding.recyclerViewHome.addItemDecoration(MarginItemDecoration(32, 2))
        binding.recyclerViewHome.adapter = adapterHomeFeature
        adapterHomeFeature.submitList(diComponent.dpHomeFeatures.getHomeFeaturesList())
    }
}