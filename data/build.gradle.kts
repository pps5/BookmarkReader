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
    api(project(":core"))
    implementation(project(":data:api"))
    implementation(project(":data:db"))
    implementation(project(":data:repository"))
    testImplementation(project(path = ":core", configuration = "testDependencies"))
}