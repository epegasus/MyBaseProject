package dev.epegasus.baseproject.helper.firebase

import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.ktx.Firebase
import dev.epegasus.baseproject.helper.utils.GeneralUtils.TAG

object FirebaseUtils {

    fun Throwable.recordException(log: String) {
        try {
            FirebaseCrashlytics.getInstance().log(log)
            FirebaseCrashlytics.getInstance().recordException(this)
            Log.e(TAG, "recordException: ${this.message.toString()}")
        } catch (e: Exception) {
            Log.e(TAG, "recordException: catch: ${e.message.toString()}")
        }
    }

    fun String.postEvent() {
        try {
            val firebaseAnalytics: FirebaseAnalytics = Firebase.analytics
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
                param(FirebaseAnalytics.Param.SCREEN_NAME, this@postEvent.lowercase())
            }

        } catch (ex: Exception) {
            try {
                FirebaseCrashlytics.getInstance().log("post_event_crash")
                FirebaseCrashlytics.getInstance().recordException(ex)

            } catch (e: Exception) {
                Log.e(TAG, "recordException: ${e.message.toString()}")
            }
        }
    }
}