package net.pubnative.lite.presentation.composables

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.pubnative.lite.R
import net.pubnative.lite.presentation.MainScreenInteractor
import net.pubnative.lite.utils.BottomNavItem

@Composable
fun MainBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Banner,
        BottomNavItem.Interstitial,
        BottomNavItem.Rewarded
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color(R.color.black)
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
fun MainScreenView(mainScreenInteractor: MainScreenInteractor) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { MainBottomNavigation(navController = navController) }
    ) {
        NavigationGraph(
            navController = navController,
            mainScreenInteractor = mainScreenInteractor
        )
    }
}