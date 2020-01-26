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

configurations {
    create("allDependencies").extendsFrom(implementation.get())
}

dependencies {
    implementation(project(":entity"))
    implementation(project(":core"))
    implementation(project(":data:repository"))

    implementation(Dep.Dagger.core)

    testImplementation(project(path = ":core", configuration = "testDependencies"))
}