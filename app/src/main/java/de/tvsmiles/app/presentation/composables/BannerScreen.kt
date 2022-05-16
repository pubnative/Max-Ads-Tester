package de.tvsmiles.app.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    onLoadBanner: (maxAdView: MaxAdView) -> Unit,
    onShowBanner: (maxAdView: MaxAdView) -> Unit
) {

    val ctx = LocalContext.current

    val maxAdViewState = remember {
        mutableStateOf(MaxAdView(BuildConfig.BANNER_AD_UNIT_ID, ctx))
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.white))
    ) {

        Column {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 20.dp, end = 10.dp, bottom = 0.dp
                ), onClick = {
                onLoadBanner.invoke(maxAdViewState.value)
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
                onShowBanner.invoke(maxAdViewState.value)
            }) {
                Text(
                    "show Ad",
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp)
                )
            }

            Spacer(modifier = Modifier.size(30.dp))

            AndroidView(factory = {
                maxAdViewState.value
            }, update = {
                maxAdViewState.value = it
            })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BannerScreenPreview() {
    BannerScreen(onShowBanner = {

    }, onLoadBanner = {

    })
}