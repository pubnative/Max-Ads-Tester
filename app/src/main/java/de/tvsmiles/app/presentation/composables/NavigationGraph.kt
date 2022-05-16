package de.tvsmiles.app.presentation.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.applovin.mediation.ads.MaxAdView
import de.tvsmiles.app.presentation.widgets.BottomNavItem

@Composable
fun NavigationGraph(
    navController: NavHostController,
    onLoadBanner: (maxAdView: MaxAdView) -> Unit,
    onLoadInterstitial: () -> Unit,
    onShowInterstitial: () -> Unit,
    onLoadRewarded: () -> Unit,
    onShowRewarded: () -> Unit
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
    }
}