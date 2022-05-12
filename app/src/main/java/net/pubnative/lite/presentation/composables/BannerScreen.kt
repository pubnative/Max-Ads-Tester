package net.pubnative.lite.presentation.composables

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.applovin.mediation.ads.MaxAdView
import net.pubnative.lite.BuildConfig
import net.pubnative.lite.R

@Composable
fun BannerScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    val maxAdsViewState = remember {
        mutableStateOf(MaxAdView(BuildConfig.AD_UNIT_ID, context))
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white))
    ) {

        Column {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 20.dp, end = 10.dp, bottom = 0.dp
                ), onClick = {
                onLoadBannerClicked(maxAdsViewState)
            }) {
                Text(
                    "Load Ad",
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp)
                )
            }

            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 10.dp, end = 10.dp, bottom = 0.dp
                ), onClick = {
                onShowBannerClicked(maxAdsViewState)
            }) {
                Text(
                    "show Ad",
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp)
                )
            }

            Spacer(modifier = Modifier.size(30.dp))

            val isInEditMode = LocalInspectionMode.current
            if (isInEditMode) {
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(Color.Red)
                        .padding(horizontal = 2.dp, vertical = 6.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    text = "Advert Here",
                )
            } else {
                AndroidView(
                    modifier = modifier.fillMaxWidth(),
                    factory = {
                        maxAdsViewState.value
                    }
                )
            }
        }
    }
}

fun onLoadBannerClicked(maxAdsViewState: MutableState<MaxAdView>) {
    val adView = maxAdsViewState.value
    adView.loadAd()
}

fun onShowBannerClicked(maxAdsViewState: MutableState<MaxAdView>) {
    val adView = maxAdsViewState.value
    adView.visibility = View.VISIBLE
    adView.startAutoRefresh()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BannerScreenPreview() {
    BannerScreen()
}