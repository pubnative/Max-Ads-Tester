package net.pubnative.lite.domain

interface Repository {
    fun fetchBannerAd()
    fun fetchInterstitialAd()
    fun fetchRewardedAd()
}