package dev.epegasus.baseproject.helper.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.fragment.app.Fragment
import dev.epegasus.baseproject.helper.firebase.FirebaseUtils.recordException

class ToolsUtils {

    fun Fragment.copyClipboardData(mData: String) {
        context?.let {
            try {
                val clipboard = it.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip: ClipData = ClipData.newPlainText(
                    "simple text",
                    mData
                )
                clipboard.setPrimaryClip(clip)
            } catch (e: Exception) {
                e.recordException("ToolsUtils: copyClipboardData: Exception")
            }
        }
    }
}