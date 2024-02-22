package com.verve.maxads.demo.presentation.widgets

import com.verve.maxads.demo.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screenRoute: String
) {
    object Banner : BottomNavItem("Banner", R.drawable.album, "banner")
    object Interstitial : BottomNavItem("Interstitial", R.drawable.album, "interstitial")
    object Rewarded : BottomNavItem("Rewarded", R.drawable.album, "rewarded")
    object SETTINGS : BottomNavItem("Settings", R.drawable.album, "settings")
}