package dev.epegasus.baseproject.helper.extensions

import android.graphics.Color
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment

object AttributesExtensions {

    @ColorInt
    fun Fragment.getColorFromAttr(@AttrRes attrColor: Int): Int {
        context?.let {
            val typedArray = it.theme.obtainStyledAttributes(intArrayOf(attrColor))
            val textColor = typedArray.getColor(0, 0)
            typedArray.recycle()
            return textColor
        } ?: return Color.BLACK
    }
}