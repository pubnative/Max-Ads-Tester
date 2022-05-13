package de.tvsmiles.app.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.applovin.mediation.MaxAd
import com.applovin.mediation.MaxAdViewAdListener
import com.applovin.mediation.MaxError
import com.applovin.mediation.ads.MaxAdView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import de.tvsmiles.app.BuildConfig.BANNER_AD_UNIT_ID
import de.tvsmiles.app.presentation.composables.MainScreenView
import de.tvsmiles.app.utils.theme.MaxAdsMainTheme

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MaxAdViewAdListener {

    private var bannerAdView: MaxAdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainActivityLayout {
                MainScreenView(
                    onLoadBanner = {
                        bannerAdView?.loadAd()
                    },
                    onShowBanner = {
                        bannerAdView?.visibility = View.VISIBLE
                        bannerAdView?.startAutoRefresh()
                    },
                    bannerAdView = bannerAdView,
                    onLoadInterstitial = {

                    },
                    onShowInterstitial = {

                    },
                    onLoadRewarded = {

                    }
                ) {

                }
            }
        }

        createBannerAd()
    }

    private fun createBannerAd() {
        bannerAdView = MaxAdView(BANNER_AD_UNIT_ID, this)
        bannerAdView?.setListener(this)
    }

    override fun onAdLoaded(ad: MaxAd?) {
        Log.d(TAG, "onAdLoaded: ")
    }

    override fun onAdDisplayed(ad: MaxAd?) {
        Log.d(TAG, "onAdDisplayed: ")
    }

    override fun onAdHidden(ad: MaxAd?) {
        Log.d(TAG, "onAdHidden: ")
    }

    override fun onAdClicked(ad: MaxAd?) {
        Log.d(TAG, "onAdClicked: ")
    }

    override fun onAdLoadFailed(adUnitId: String?, error: MaxError?) {
        Log.d(TAG, "onAdLoadFailed: ")
        Snackbar.make(
            findViewById(android.R.id.content),
            "Failed to load Ad",
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onAdDisplayFailed(ad: MaxAd?, error: MaxError?) {
        Log.d(TAG, "onAdDisplayFailed: ")
    }

    override fun onAdExpanded(ad: MaxAd?) {
        Log.d(TAG, "onAdExpanded: ")
    }

    override fun onAdCollapsed(ad: MaxAd?) {
        Log.d(TAG, "onAdCollapsed: ")
    }

    override fun onStop() {
        bannerAdView?.visibility = View.GONE
        bannerAdView?.stopAutoRefresh()
        super.onStop()
    }
}

@Composable
fun MainActivityLayout(content: @Composable () -> Unit) {
    MaxAdsMainTheme {
        content()
    }
}