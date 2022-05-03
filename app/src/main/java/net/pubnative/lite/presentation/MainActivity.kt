package net.pubnative.lite.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import net.pubnative.lite.presentation.composables.MainScreenView
import net.pubnative.lite.ui.theme.MaxAdsMainTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainScreenInteractor {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaxAdsMainTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreenView(this@MainActivity)
                }
            }
        }
    }

    override fun onShowBannerClicked() {
        viewModel.fetchBannerAd()
    }

    override fun onShowInterstitialClicked() {
        viewModel.fetchInterstitialAd()
    }

    override fun onShowRewardedClicked() {
        viewModel.fetchRewardedAd()
    }
}