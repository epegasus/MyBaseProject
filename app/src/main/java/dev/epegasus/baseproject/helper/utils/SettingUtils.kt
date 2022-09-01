package dev.epegasus.baseproject.helper.utils

import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import androidx.fragment.app.Fragment
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.helper.extensions.FragmentExtensions.showToast

object SettingUtils {

    fun Fragment.rateApp() {
        context?.let {
            val url: String = "https://play.google.com/store/apps/details?id=" + it.packageName
            if (URLUtil.isValidUrl(url)) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                it.startActivity(intent)
            } else
                showToast(it.resources.getString(R.string.invalid_link))
        }
    }

    fun Fragment.shareApp() {
        context?.let {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, it.resources.getString(R.string.app_name))
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=${it.packageName}")
            sendIntent.type = "text/plain"
            it.startActivity(sendIntent)
        }
    }

    fun Fragment.openPrivacyPolicy() {
        context?.let {
            val url: String = it.resources.getString(R.string.privacy_policy_link)
            if (URLUtil.isValidUrl(url)) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                it.startActivity(intent)
            } else
                showToast(it.resources.getString(R.string.invalid_link))
        }
    }
}