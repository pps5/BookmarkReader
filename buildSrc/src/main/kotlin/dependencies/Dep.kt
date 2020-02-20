package dependencies

object Dep {

    @Suppress("unused")
    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:4.0.0-alpha08"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.1.0"
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val material = "com.google.android.material:material:1.1.0-rc01"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:2.2.0"
        const val liveData = "androidx.lifecycle:lifecycle-livedata:2.2.0"
        const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.1.0"

        object Room {
            private const val version = "2.2.0-rc01"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
        }
    }

    object Dagger {
        private const val version = "2.25.4"
        const val core = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val support = "com.google.dagger:dagger-android-support:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object TikXML {
        private const val version = "0.8.13"
        const val core = "com.tickaroo.tikxml:core:$version"
        const val annotation = "com.tickaroo.tikxml:annotation:$version"
        const val htmlEscape = "com.tickaroo.tikxml:converter-htmlescape:$version"
        const val retrofitConverter = "com.tickaroo.tikxml:retrofit-converter:$version"
        const val processor = "com.tickaroo.tikxml:processor:$version"
    }

    object Groupie {
        private const val version = "2.7.0"
        const val core = "com.xwray:groupie:$version"
        const val extension = "com.xwray:groupie-kotlin-android-extensions:$version"
        const val dataBinding = "com.xwray:groupie-databinding:$version"
    }

    object Glide {
        private const val version = "4.11.0"
        const val core = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Hyperion {
        private const val version = "0.9.27"
        const val core = "com.willowtreeapps.hyperion:hyperion-core:$version"
        const val attr = "com.willowtreeapps.hyperion:hyperion-attr:$version"
        const val measurement = "com.willowtreeapps.hyperion:hyperion-measurement:$version"
        const val timber = "com.willowtreeapps.hyperion:hyperion-timber:$version"
        const val crash = "com.willowtreeapps.hyperion:hyperion-crash:$version"
    }

    const val okHttp3 = "com.squareup.okhttp3:okhttp:4.3.1"
    const val retrofit = "com.squareup.retrofit2:retrofit:2.7.0"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val threeTenAbp = "com.jakewharton.threetenabp:threetenabp:1.2.2"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.2"

    object Test {
        const val jUnit = "junit:junit:4.12"
    }
}