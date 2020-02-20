import dependencies.Dep
import dependencies.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)

    defaultConfig {
        applicationId = "io.github.pps5.bookmarkreader"
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)

        versionCode = Versions.versionCode
        versionName = Versions.versionName
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":feature:home"))
    implementation(project(":feature:entries"))
    implementation(project(":data"))
    implementation(project(":data:api"))
    implementation(project(":data:db"))
    implementation(project(":data:repository"))

    implementation(project(path = ":data:api", configuration = "allDependencies"))
    implementation(project(path = ":data:db", configuration = "allDependencies"))
    implementation(project(path = ":feature:home", configuration = "allDependencies"))
    implementation(project(path = ":feature:entries", configuration = "allDependencies"))

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.appCompat)
    implementation(Dep.AndroidX.constraintLayout)
    implementation(Dep.AndroidX.material)

    implementation(Dep.Dagger.core)
    implementation(Dep.Dagger.android)
    implementation(Dep.Dagger.support)
    kapt(Dep.Dagger.compiler)
    kapt(Dep.Dagger.androidProcessor)

    debugImplementation(Dep.Hyperion.core)
    debugImplementation(Dep.Hyperion.measurement)
    debugImplementation(Dep.Hyperion.attr)
    debugImplementation(Dep.Hyperion.timber)
    debugImplementation(Dep.Hyperion.crash)
    debugImplementation(Dep.leakCanary)

    testImplementation(project(path = ":core", configuration = "testDependencies"))
}