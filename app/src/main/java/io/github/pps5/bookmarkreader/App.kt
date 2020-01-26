package io.github.pps5.bookmarkreader

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.pps5.bookmarkreader.di.DaggerAppComponent
import timber.log.Timber

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .context(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}