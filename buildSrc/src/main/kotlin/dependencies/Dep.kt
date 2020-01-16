package dependencies

object Dep {

    @Suppress("unused")
    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:4.0.0-alpha08"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.1.0"
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    }

    object Test {
        const val jUnit = "junit:junit:4.12"
    }
}