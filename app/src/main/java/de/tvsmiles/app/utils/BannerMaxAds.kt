package de.tvsmiles.app.utils

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdViewAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxAdView

private const val TAG = "loadBanner"

fun loadBannerAd(maxAdView: MaxAdView?) {

    maxAdView?.setListener(object : MaxAdViewAdListener {
        override fun onAdLoaded(ad: MaxAd?) {
            Log.d(TAG, "onAdLoaded")
        }

        override fun onAdClicked(ad: MaxAd?) {
            Log.d(TAG, "onAdClicked")
        }

        override fun onAdLoadFailed(adUnitId: String?, error: MaxError?) {
            Log.d(TAG, "onAdLoadFailed")
            maxAdView.loadAd()
        }

        override fun onAdDisplayFailed(ad: MaxAd?, error: MaxError?) {
            Log.d(TAG, "onAdDisplayFailed")
            maxAdView.loadAd()
        }

        override fun onAdExpanded(ad: MaxAd?) {
            Log.d(TAG, "onAdExpanded")
        }

        override fun onAdCollapsed(ad: MaxAd?) {
            Log.d(TAG, "onAdCollapsed")
        }

        override fun onAdDisplayed(ad: MaxAd?) {
            Log.d(TAG, "onAdDisplayed")
        }

        override fun onAdHidden(ad: MaxAd?) {
            Log.d(TAG, "onAdHidden")
        }

    })

    maxAdView?.loadAd()
}

fun showBannerAd(maxAdView: MaxAdView?, activity: Activity) {
    if (maxAdView != null) {
        maxAdView.visibility = View.VISIBLE
        maxAdView.startAutoRefresh()
    } else {
        Log.d(TAG, "showBannerAd: The Ad is not ready yet")
        Toast.makeText(activity, "Banner Ad is not ready yet", Toast.LENGTH_SHORT).show()
    }
}