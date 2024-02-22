package com.verve.maxads.demo.utils

import android.util.Log
import android.view.View
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdViewAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxAdView

private const val TAG = "loadBanner"

fun loadBannerAd(maxAdView: MaxAdView?) {
    maxAdView?.setExtraParameter("adaptive_banner", "true")
    maxAdView?.placement = "110";

    maxAdView?.setListener(object : MaxAdViewAdListener {
        override fun onAdLoaded(ad: MaxAd) {
            Log.d(TAG, "onAdLoaded")
            maxAdView.visibility = View.VISIBLE
            maxAdView.startAutoRefresh()
        }

        override fun onAdClicked(ad: MaxAd) {
            Log.d(TAG, "onAdClicked")
        }

        override fun onAdLoadFailed(adUnitId: String, error: MaxError) {
            Log.d(TAG, "onAdLoadFailed")
            Log.d(TAG, error.message)
            Log.d(TAG, error.code.toString())
            Log.d(TAG, "onAdLoadFailed")
            maxAdView.loadAd()
        }

        override fun onAdDisplayFailed(ad: MaxAd, error: MaxError) {
            Log.d(TAG, "onAdDisplayFailed")
            maxAdView.loadAd()
        }

        override fun onAdExpanded(ad: MaxAd) {
            Log.d(TAG, "onAdExpanded")
        }

        override fun onAdCollapsed(ad: MaxAd) {
            Log.d(TAG, "onAdCollapsed")
        }

        // These two below are not used with Banner - Only for fullscreen ads
        override fun onAdDisplayed(ad: MaxAd) {
            Log.d(TAG, "onAdDisplayed")
        }

        override fun onAdHidden(ad: MaxAd) {
            Log.d(TAG, "onAdHidden")
        }

    })

    maxAdView?.loadAd()
}