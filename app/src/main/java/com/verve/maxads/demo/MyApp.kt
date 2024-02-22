package com.verve.maxads.demo

import android.app.Application
import android.util.Log
import android.webkit.WebView
import com.applovin.sdk.AppLovinMediationProvider
import com.applovin.sdk.AppLovinSdk
import dagger.hilt.android.HiltAndroidApp
import net.pubnative.lite.sdk.HyBid
import net.pubnative.lite.sdk.utils.Logger

@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            initSettings()
        } catch (exception: Exception) {
        }
    }

    private fun initSettings() {
        HyBid.initialize("dde3c298b47648459f8ada4a982fa92d", this) {
            if (it) {
                WebView.setWebContentsDebuggingEnabled(true)
                HyBid.setLogLevel(Logger.Level.debug)
                HyBid.setTestMode(true)
                if (!AppLovinSdk.getInstance(applicationContext).isInitialized) {
                    AppLovinSdk.getInstance(this).mediationProvider =
                        AppLovinMediationProvider.MAX
                    AppLovinSdk.getInstance(this)
                        .initializeSdk { applovinConfiguration ->
                            Log.d(
                                "Applovin SDK initialisation",
                                "onCreate: $applovinConfiguration"
                            )
                        }
                }
            }
        }
    }
}