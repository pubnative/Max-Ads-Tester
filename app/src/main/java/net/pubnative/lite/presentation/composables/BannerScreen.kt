package net.pubnative.lite.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.pubnative.lite.R
import net.pubnative.lite.presentation.MainScreenInteractor
import net.pubnative.lite.ui.theme.MaxAdsMainTheme

@Composable
fun BannerScreen(listener: MainScreenInteractor?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white))
    ) {
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp, top = 20.dp, end = 10.dp, bottom = 0.dp
            ), onClick = {
            onBannerAdClicked(listener)
        }) {
            Text(
                "show Banner Ad",
                maxLines = 1,
                modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(
                    start = 10.dp, top = 10.dp, end = 10.dp, bottom = 0.dp
                )
        ) {

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BannerScreen() {
    BannerScreen(object : MainScreenInteractor {
        override fun onShowBannerClicked() {
            TODO("Not yet implemented")
        }

        override fun onShowInterstitialClicked() {
            TODO("Not yet implemented")
        }

        override fun onShowRewardedClicked() {
            TODO("Not yet implemented")
        }
    })
}

fun onBannerAdClicked(listener: MainScreenInteractor?) {
    listener?.onShowBannerClicked()
}
