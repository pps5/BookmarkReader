package io.github.pps5.bookmarkreader

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.pps5.bookmarkreader.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .context(this)
            .build()
    }

}