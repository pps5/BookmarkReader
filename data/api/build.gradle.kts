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
}

configurations {
    create("allDependencies").extendsFrom(implementation.get())
}

dependencies {
    implementation(project(":core"))
    implementation(project(":entity"))
    implementation(Dep.retrofit)
    implementation(Dep.okHttp3)

    implementation(Dep.TikXML.core)
    implementation(Dep.TikXML.annotation)
    implementation(Dep.TikXML.htmlEscape)
    implementation(Dep.TikXML.retrofitConverter)
    kapt(Dep.TikXML.processor)

    implementation(Dep.Dagger.core)
    kapt(Dep.Dagger.compiler)

    testImplementation(project(path = ":core", configuration = "testDependencies"))
}

kapt {
    arguments {
        arg("primitiveTypeConverters", "java.lang.String")
    }
}