pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://verve.jfrog.io/artifactory/verve-gradle-release" )
        maven("https://verve.jfrog.io/artifactory/verve-gradle-dev" )
        maven("https://jitpack.io" )
        gradlePluginPortal()
    }
}

buildscript {
    repositories {
        maven { url = uri("https://artifacts.applovin.com/android") }
    }
    dependencies {
        classpath ("com.applovin.quality:AppLovinQualityServiceGradlePlugin:5.0.7")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://verve.jfrog.io/artifactory/verve-gradle-release" )
        maven("https://verve.jfrog.io/artifactory/verve-gradle-dev" )
        maven("https://jitpack.io" )
    }
}
rootProject.name = "pubnative-max-ads-tester-android"
include(":app")