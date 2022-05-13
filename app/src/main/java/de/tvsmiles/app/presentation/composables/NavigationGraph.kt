package de.tvsmiles.app.presentation.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.applovin.mediation.ads.MaxAdView
import de.tvsmiles.app.utils.BottomNavItem

@Composable
fun NavigationGraph(
    navController: NavHostController,
    bannerAdView: MaxAdView?,
    onLoadBanner: () -> Unit,
    onShowBanner: () -> Unit,
    onLoadInterstitial: () -> Unit,
    onShowInterstitial: () -> Unit,
    onLoadRewarded: () -> Unit,
    onShowRewarded: () -> Unit
) {
    NavHost(navController, startDestination = BottomNavItem.Banner.screenRoute) {
        composable(BottomNavItem.Banner.screenRoute) {
            BannerScreen(
                onLoadBanner = onLoadBanner,
                onShowBanner = onShowBanner,
                adView = bannerAdView
            )
        }
        composable(BottomNavItem.Interstitial.screenRoute) {
            InterstitialScreen(onLoadInterstitial, onShowInterstitial)
        }
        composable(BottomNavItem.Rewarded.screenRoute) {
            RewardedScreen(onLoadRewarded, onShowRewarded)
        }
    }
}