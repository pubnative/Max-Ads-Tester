package de.tvsmiles.app.utils

import android.app.Activity
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxInterstitialAd
import de.tvsmiles.app.BuildConfig
import java.util.concurrent.TimeUnit
import kotlin.math.pow

private var interstitialAd: MaxInterstitialAd? = null
private var retryAttempt = 0.0

private const val TAG = "loadInterstitial"

fun createInterstitialAd(activity: Activity) {
    interstitialAd = MaxInterstitialAd(BuildConfig.INTERSTITIAL_AD_UNIT_ID, activity)
    interstitialAd?.setListener(object : MaxAdListener {
        override fun onAdLoaded(ad: MaxAd) {
            Log.d(TAG, "onAdLoaded: ")
            retryAttempt = 0.0
        }

        override fun onAdDisplayed(ad: MaxAd) {
            Log.d(TAG, "onAdDisplayed: ")
        }

        override fun onAdHidden(ad: MaxAd) {
            Log.d(TAG, "onAdHidden: ")
            interstitialAd?.loadAd()
        }

        override fun onAdClicked(ad: MaxAd) {
            Log.d(TAG, "onAdClicked: ")
        }

        override fun onAdLoadFailed(adUnitId: String, error: MaxError) {
            Log.d(TAG, "onAdLoadFailed: ")
            retryAttempt++

            val delayMillis =
                TimeUnit.SECONDS.toMillis(2.0.pow(6.0.coerceAtMost(retryAttempt)).toLong())

            Handler().postDelayed({ interstitialAd?.loadAd() }, delayMillis)
        }

        override fun onAdDisplayFailed(ad: MaxAd, error: MaxError) {
            Log.d(TAG, "onAdDisplayFailed: ")
            interstitialAd?.loadAd()
        }
    })

    // Load the first ad
    interstitialAd?.loadAd()
}

fun showInterstitialAd(activity: Activity) {
    if (interstitialAd?.isReady == false) {
        Toast.makeText(activity, "Interstitial Ad is not ready yet", Toast.LENGTH_SHORT).show()
        return
    }

    interstitialAd?.let {
        if (it.isReady) {
            it.showAd()
        }
    }
}