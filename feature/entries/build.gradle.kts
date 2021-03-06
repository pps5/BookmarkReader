import dependencies.Dep
import dependencies.Versions

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

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }

    androidExtensions {
        isExperimental = true
        features = setOf("parcelize")
    }
}

configurations {
    create("allDependencies").extendsFrom(implementation.get())
}

dependencies {
    implementation(project(":entity"))
    implementation(project(":core"))
    implementation(project(":data:repository"))

    implementation(Dep.AndroidX.core)
    implementation(Dep.AndroidX.constraintLayout)
    implementation(Dep.AndroidX.viewModel)
    implementation(Dep.AndroidX.liveData)
    implementation(Dep.AndroidX.liveDataKtx)
    implementation(Dep.AndroidX.material)
    implementation(Dep.AndroidX.fragment)

    implementation(Dep.Dagger.core)
    implementation(Dep.Dagger.support)
    kapt(Dep.Dagger.compiler)
    kapt(Dep.Dagger.androidProcessor)

    implementation(Dep.Groupie.core)
    implementation(Dep.Groupie.dataBinding)

    implementation(Dep.Glide.core)
    kapt(Dep.Glide.compiler)

    testImplementation(project(path = ":core", configuration = "testDependencies"))
}