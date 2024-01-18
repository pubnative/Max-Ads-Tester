@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.daggerHilt)
    alias(libs.plugins.navigationsafeargskotlin)
    alias(libs.plugins.ksp)
}

//applovin {
//    apiKey "DLFowD1XQnNMxQ5vN0qgKTgBObZRdDbsiz5f67ziKuCKyh3kAOzQyVMTBPCE8g3GHVzK4EUHyQHPA4f4zn9P8u"
//}

android {
    namespace = "de.tvsmiles.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "de.tvsmiles.app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BANNER_AD_UNIT_ID", "\"8325b47ac20344a8\"")
            buildConfigField("String", "INTERSTITIAL_AD_UNIT_ID", "\"82b96c35009bb34c\"")
            buildConfigField("String", "REWARDED_AD_UNIT_ID", "\"15819e655d2464b0\"")
        }

        debug {
            buildConfigField("String", "BANNER_AD_UNIT_ID", "\"8325b47ac20344a8\"")
            buildConfigField("String", "INTERSTITIAL_AD_UNIT_ID", "\"82b96c35009bb34c\"")
            buildConfigField("String", "REWARDED_AD_UNIT_ID", "\"15819e655d2464b0\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.liveData)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.material)
    implementation(libs.navigation.version)
    //HyBid
    implementation(libs.hybid)
    implementation(libs.hybid.omsdk)
    implementation(libs.hybid.applovin.adapter)
    //Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    //Applovin
    implementation(libs.applovin.sdk)
    implementation(libs.installreferrer)
    implementation(libs.play.services.ads.identifier)
    implementation(libs.play.services.base)
    //Testing
    testImplementation(libs.junit)
    testImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}