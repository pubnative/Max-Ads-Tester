package de.tvsmiles.app.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.applovin.sdk.AppLovinMediationProvider
import com.applovin.sdk.AppLovinSdk
import dagger.hilt.android.AndroidEntryPoint
import de.tvsmiles.app.presentation.composables.MainScreenView
import de.tvsmiles.app.utils.*
import de.tvsmiles.app.utils.theme.MaxAdsMainTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainActivityLayout {
                MainScreenView(
                    onLoadBanner = {
                        AppLovinSdk.getInstance(this@MainActivity).mediationProvider =
                            AppLovinMediationProvider.MAX
                        AppLovinSdk.getInstance(this@MainActivity)
                            .initializeSdk { applovinConfiguration ->
                                Log.d(
                                    "Applovin SDK initialisation",
                                    "onCreate: $applovinConfiguration"
                                )
                                loadBannerAd(it)
                            }
                    },
                    onShowBanner = {
                        showBannerAd(it)
                    },
                    onLoadInterstitial = {
                        createInterstitialAd(this@MainActivity)
                    },
                    onShowInterstitial = {
                        showInterstitialAd()
                    },
                    onLoadRewarded = {
                        createRewardedAd(this@MainActivity)
                    },
                    onShowRewarded = {
                        showRewardedAd()
                    }
                )
            }
        }
    }
}

@Composable
fun MainActivityLayout(content: @Composable () -> Unit) {
    MaxAdsMainTheme {
        content()
    }
}