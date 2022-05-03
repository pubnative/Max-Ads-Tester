package net.pubnative.lite.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import net.pubnative.lite.presentation.composables.MainScreenView
import net.pubnative.lite.ui.theme.MaxAdsMainTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainScreenInteractor {

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
        Log.d("onShowBannerClicked","clicked")
    }

    override fun onShowInterstitialClicked() {
        Log.d("onShowInterstitialClicked","clicked")
    }

    override fun onShowRewardedClicked() {
        Log.d("onShowRewardedClicked","clicked")
    }
}