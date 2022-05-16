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
                        initialiseApplovinSDK {
                            loadBannerAd(it)
                        }
                    },
                    onShowBanner = {
                        showBannerAd(it,this@MainActivity)
                    },
                    onLoadInterstitial = {
                        initialiseApplovinSDK {
                            createInterstitialAd(this@MainActivity)
                        }
                    },
                    onShowInterstitial = {
                        showInterstitialAd(this@MainActivity)
                    },
                    onLoadRewarded = {
                        initialiseApplovinSDK {
                            createRewardedAd(this@MainActivity)
                        }
                    },
                    onShowRewarded = {
                        showRewardedAd(this@MainActivity)
                    }
                )
            }
        }
    }

    private fun initialiseApplovinSDK(content: () -> Unit) {
        if (!AppLovinSdk.getInstance(applicationContext).isInitialized) {
            AppLovinSdk.getInstance(this@MainActivity).mediationProvider =
                AppLovinMediationProvider.MAX
            AppLovinSdk.getInstance(this@MainActivity)
                .initializeSdk { applovinConfiguration ->
                    Log.d(
                        "Applovin SDK initialisation",
                        "onCreate: $applovinConfiguration"
                    )
                    content.invoke()
                }
        } else {
            content.invoke()
        }
    }
}

@Composable
fun MainActivityLayout(content: @Composable () -> Unit) {
    MaxAdsMainTheme {
        content()
    }
}