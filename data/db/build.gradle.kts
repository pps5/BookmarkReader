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

kapt {
    arguments {
        arg("room.incremental", "true")
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":entity"))

    implementation(Dep.AndroidX.Room.runtime)
    implementation(Dep.AndroidX.Room.ktx)
    kapt(Dep.AndroidX.Room.compiler)

    implementation(Dep.Dagger.core)
    kapt(Dep.Dagger.compiler)

    testImplementation(project(path = ":core", configuration = "testDependencies"))
}