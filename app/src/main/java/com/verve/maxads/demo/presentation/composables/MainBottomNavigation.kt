package com.verve.maxads.demo.presentation.composables

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.applovin.mediation.ads.MaxAdView
import com.verve.maxads.demo.presentation.widgets.BottomNavItem
import com.verve.maxads.demo.R

@Composable
fun MainBottomNavigation(
    navController: NavController
) {

    val items = listOf(
        BottomNavItem.Banner,
        BottomNavItem.Interstitial,
        BottomNavItem.Rewarded,
        BottomNavItem.SETTINGS,
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.screenRoute,
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title, fontSize = 12.sp)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.screenRoute) {

                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainScreenView(
    onLoadBanner: (maxAdView: MaxAdView) -> Unit,
    onLoadInterstitial: () -> Unit,
    onShowInterstitial: () -> Unit,
    onLoadRewarded: () -> Unit,
    onShowRewarded: () -> Unit,
    onShowSettings: () -> Unit,
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            MainBottomNavigation(
                navController = navController
            )
        }
    ) {
        NavigationGraph(
            navController = navController,
            onLoadBanner = onLoadBanner,
            onLoadInterstitial = onLoadInterstitial,
            onShowInterstitial = onShowInterstitial,
            onLoadRewarded = onLoadRewarded,
            onShowRewarded = onShowRewarded,
            onShowSettings = onShowSettings
        )
    }
}