package dev.epegasus.baseproject.helper.adapters.binding

import android.view.View
import androidx.databinding.BindingAdapter
import dev.epegasus.baseproject.helper.listeners.DebounceListener.setDebounceClickListener

@BindingAdapter(value = ["debounceClick", "isSaved"], requireAll = false)
fun setDebouncedClick(view: View, debounceClick: () -> Unit, isSaved: Boolean) {
    if (!isSaved) {
        view.setOnClickListener {
            debounceClick.invoke()
        }
        return
    }
    view.setDebounceClickListener {
        debounceClick.invoke()
    }
}