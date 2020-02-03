import dependencies.Versions
import dependencies.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        consumerProguardFiles("consumer-rules.pro")
    }
}

configurations {
    create("testDependencies").extendsFrom(testImplementation.get())
}

dependencies {
    implementation(project(":entity"))
    api(Dep.Kotlin.stdLib)
    api(Dep.Kotlin.coroutines)
    api(Dep.AndroidX.Navigation.fragment)
    api(Dep.AndroidX.Navigation.ui)
    api(Dep.timber)
    api(Dep.threeTenAbp)
    implementation(Dep.Dagger.core)
    testImplementation(Dep.Test.jUnit)
}
