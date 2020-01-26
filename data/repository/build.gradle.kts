import dependencies.Versions
import dependencies.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
    implementation(project(":core"))
    implementation(project(":entity"))
    implementation(project(":data:api"))

    implementation(Dep.Dagger.core)
    kapt(Dep.Dagger.compiler)

    testImplementation(project(path = ":core", configuration = "testDependencies"))
}