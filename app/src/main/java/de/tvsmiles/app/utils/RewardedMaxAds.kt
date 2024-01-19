package de.tvsmiles.app.utils

import android.app.Activity
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxError
import com.applovin.mediation.MaxReward
import com.applovin.mediation.MaxRewardedAdListener
import com.applovin.mediation.ads.MaxRewardedAd
import de.tvsmiles.app.BuildConfig
import java.util.concurrent.TimeUnit
import kotlin.math.pow

private var rewardedAd: MaxRewardedAd? = null
private var retryAttempt = 0.0

private const val TAG = "loadRewarded"

fun createRewardedAd(activity: Activity) {
    rewardedAd = MaxRewardedAd.getInstance(BuildConfig.REWARDED_AD_UNIT_ID, activity)

    rewardedAd?.setListener(object : MaxRewardedAdListener {
        override fun onAdLoaded(ad: MaxAd) {
            Log.d(TAG, "onAdLoaded: ")
        }

        override fun onAdDisplayed(ad: MaxAd) {
            Log.d(TAG, "onAdDisplayed: ")
            retryAttempt = 0.0
        }

        override fun onAdHidden(ad: MaxAd) {
            Log.d(TAG, "onAdHidden: ")
            rewardedAd?.loadAd()
        }

        override fun onAdClicked(ad: MaxAd) {
            Log.d(TAG, "onAdClicked: ")
        }

        override fun onAdLoadFailed(adUnitId: String, error: MaxError) {
            Log.d(TAG, "onAdLoadFailed: ")
            retryAttempt++
            val delayMillis =
                TimeUnit.SECONDS.toMillis(2.0.pow(6.0.coerceAtMost(retryAttempt)).toLong())

            Handler().postDelayed({ rewardedAd?.loadAd() }, delayMillis)

        }

        override fun onAdDisplayFailed(ad: MaxAd, error: MaxError) {
            Log.d(TAG, "onAdDisplayFailed: ")
            rewardedAd?.loadAd()
        }

        override fun onRewardedVideoStarted(ad: MaxAd) {
            Log.d(TAG, "onRewardedVideoStarted: ")
        }

        override fun onRewardedVideoCompleted(ad: MaxAd) {
            Log.d(TAG, "onRewardedVideoCompleted: ")
        }

        override fun onUserRewarded(ad: MaxAd, reward: MaxReward) {
            Log.d(TAG, "onUserRewarded: ")
        }

    })

    rewardedAd?.loadAd()
}

fun showRewardedAd(activity: Activity) {
    if (rewardedAd?.isReady == false) {
        Toast.makeText(activity, "Rewarded Ad is not ready yet", Toast.LENGTH_SHORT).show()
        return
    }

    rewardedAd?.let {
        if (it.isReady) {
            it.showAd()
        }
    }
}