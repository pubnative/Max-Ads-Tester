pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://artifacts.applovin.com/android" )
        maven("https://verve.jfrog.io/artifactory/verve-gradle-release" )
        maven("https://verve.jfrog.io/artifactory/verve-gradle-dev" )
        maven("https://jitpack.io" )
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://artifacts.applovin.com/android") }
        maven { url = uri("https://verve.jfrog.io/artifactory/verve-gradle-release") }
        maven { url = uri("https://verve.jfrog.io/artifactory/verve-gradle-dev") }
        maven { url = uri("https://jitpack.io") }
    }
}
rootProject.name = "pubnative-max-ads-tester-android"
include(":app")