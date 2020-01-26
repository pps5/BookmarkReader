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

dependencies {
    implementation(Dep.Kotlin.stdLib)
    testImplementation(project(path = ":core", configuration = "testDependencies"))
}