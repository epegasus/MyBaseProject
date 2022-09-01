package dev.epegasus.baseproject.helper.adapters.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.databinding.ListItemHomeFeatureBinding
import dev.epegasus.baseproject.helper.interfaces.OnHomeFeatureClickListener
import dev.epegasus.baseproject.helper.models.HomeFeature

class AdapterHomeFeature(private val onHomeFeatureClickListener: OnHomeFeatureClickListener) : ListAdapter<HomeFeature, AdapterHomeFeature.ViewHolderHome>(diffUtilHomeFeature) {

    companion object {
        val diffUtilHomeFeature = object : DiffUtil.ItemCallback<HomeFeature>() {
            override fun areItemsTheSame(oldItem: HomeFeature, newItem: HomeFeature): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HomeFeature, newItem: HomeFeature): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolderHome(val binding: ListItemHomeFeatureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHome {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemHomeFeatureBinding>(layoutInflater, R.layout.list_item_home_feature, parent, false)
        return ViewHolderHome(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderHome, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            homeFeature = item
            itemClick = onHomeFeatureClickListener
        }
    }
}