import dependencies.Versions
import dependencies.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
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
    api(Dep.Kotlin.stdLib)
    api(Dep.AndroidX.Navigation.fragment)
    api(Dep.AndroidX.Navigation.ui)
    testImplementation(Dep.Test.jUnit)
}
