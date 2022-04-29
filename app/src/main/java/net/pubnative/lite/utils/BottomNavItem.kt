package net.pubnative.lite.utils

import net.pubnative.lite.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_routing: String) {
    object Banner : BottomNavItem("Banner", R.mipmap.ic_launcher, "banner")
    object Interstitial : BottomNavItem("Interstitial", R.mipmap.ic_launcher, "interstitial")
    object Rewarded : BottomNavItem("Rewarded", R.mipmap.ic_launcher, "rewarded")
}