package net.pubnative.lite.presentation.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.pubnative.lite.utils.BottomNavItem

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Banner.screenRoute) {
        composable(BottomNavItem.Banner.screenRoute) {
            BannerScreen()
        }
        composable(BottomNavItem.Interstitial.screenRoute) {
            InterstitialScreen()
        }
        composable(BottomNavItem.Rewarded.screenRoute) {
            RewardedScreen()
        }
    }
}