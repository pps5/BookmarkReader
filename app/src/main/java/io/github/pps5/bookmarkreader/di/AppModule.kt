package io.github.pps5.bookmarkreader.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.pps5.bookmarkreader.MainActivity
import io.github.pps5.bookmarkreader.data.DataModule

@Module(
    includes = [
        DataModule::class
    ]
)
abstract class AppModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}