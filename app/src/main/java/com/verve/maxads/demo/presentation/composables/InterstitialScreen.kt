package com.verve.maxads.demo.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verve.maxads.demo.R

@Composable
fun InterstitialScreen(onLoadInterstitial: () -> Unit, onShowInterstitial: () -> Unit) {
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
            onLoadInterstitial.invoke()
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
                start = 10.dp, top = 20.dp, end = 10.dp, bottom = 0.dp
            ), onClick = {
            onShowInterstitial.invoke()
        }) {
            Text(
                "show Ad",
                maxLines = 1,
                modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp)
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InterstitialScreenPreview() {
    InterstitialScreen(onLoadInterstitial = {

    }, onShowInterstitial = {

    })
}
