package dev.epegasus.baseproject.helper.extensions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

object ViewPager2Extensions {

    fun ViewPager2.removeOverScroll() {
        (getChildAt(0) as? RecyclerView)?.overScrollMode = View.OVER_SCROLL_NEVER
    }
}