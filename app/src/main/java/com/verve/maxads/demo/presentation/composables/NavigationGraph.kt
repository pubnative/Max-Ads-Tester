package com.verve.maxads.demo.presentation.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.applovin.mediation.ads.MaxAdView
import com.verve.maxads.demo.presentation.widgets.BottomNavItem

@Composable
fun NavigationGraph(
    navController: NavHostController,
    onLoadBanner: (maxAdView: MaxAdView) -> Unit,
    onLoadInterstitial: () -> Unit,
    onShowInterstitial: () -> Unit,
    onLoadRewarded: () -> Unit,
    onShowRewarded: () -> Unit,
    onShowSettings: () -> Unit
) {
    NavHost(navController, startDestination = BottomNavItem.Banner.screenRoute) {
        composable(BottomNavItem.Banner.screenRoute) {
            BannerScreen(
                onLoadBanner = onLoadBanner
            )
        }
        composable(BottomNavItem.Interstitial.screenRoute) {
            InterstitialScreen(onLoadInterstitial, onShowInterstitial)
        }
        composable(BottomNavItem.Rewarded.screenRoute) {
            RewardedScreen(onLoadRewarded, onShowRewarded)
        }
        composable(BottomNavItem.SETTINGS.screenRoute) {
            SettingsScreen(onShowSettings)
        }
    }
}