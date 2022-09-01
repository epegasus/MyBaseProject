package dev.epegasus.baseproject.helper.utils

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import androidx.fragment.app.Fragment
import dev.epegasus.baseproject.R
import dev.epegasus.baseproject.helper.extensions.FragmentExtensions.showToast
import dev.epegasus.baseproject.helper.firebase.FirebaseUtils.recordException

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

    fun Fragment.feedback() {
        context?.let {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "message/rfc822"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(it.resources.getString(R.string.app_email)))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, it.getString(R.string.app_name))
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Feedback...")
            try {
                it.startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                ex.recordException("SettingUtils: Feedback: ActivityNotFoundException: ")
                showToast("There are no email clients installed.")
            }
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