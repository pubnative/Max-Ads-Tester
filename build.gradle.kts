// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id ("com.android.application") version("7.4.2") apply false
    id ("org.jetbrains.kotlin.android") version("1.7.0") apply false
    id ("androidx.navigation.safeargs") version("2.7.6") apply false
    id ("com.google.dagger.hilt.android") version("2.50") apply false
    id ("com.google.devtools.ksp") version("1.9.0-1.0.12") apply false
    id("applovin-quality-service") apply false
}
true // Needed to make the Suppress annotation work for the plugins block