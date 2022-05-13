package de.tvsmiles.app.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.applovin.mediation.ads.MaxAdView
import de.tvsmiles.app.BuildConfig
import de.tvsmiles.app.R

@Composable
fun BannerScreen(
    modifier: Modifier = Modifier,
    onLoadBanner: () -> Unit,
    onShowBanner: () -> Unit,
    adView: MaxAdView?
) {

    val context = LocalContext.current

    val maxAdViewState = remember(adView) {
        mutableStateOf(MaxAdView(BuildConfig.BANNER_AD_UNIT_ID, context))
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
                onLoadBanner.invoke()
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
                onShowBanner.invoke()
            }) {
                Text(
                    "show Ad",
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp)
                )
            }

            Spacer(modifier = Modifier.size(30.dp))

            val isInEditMode = LocalInspectionMode.current

            if (!isInEditMode) {
                AndroidView(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    factory = {
                        maxAdViewState.value
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BannerScreenPreview() {

    val context = LocalContext.current

    val adView = MaxAdView(BuildConfig.BANNER_AD_UNIT_ID, context)

    val maxAdViewState = remember(adView) {
        mutableStateOf(MaxAdView(BuildConfig.BANNER_AD_UNIT_ID, context))
    }

    BannerScreen(onShowBanner = {

    }, onLoadBanner = {

    }, adView = maxAdViewState.value)
}