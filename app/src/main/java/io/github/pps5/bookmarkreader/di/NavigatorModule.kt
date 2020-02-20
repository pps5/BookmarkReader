package io.github.pps5.bookmarkreader.di

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import io.github.pps5.bookmarkreader.MainNavigator
import io.github.pps5.bookmarkreader.core.navigator.IMainNavigator

@Module
class NavigatorModule {

    @Provides
    fun provideMainNavigator(activity: AppCompatActivity): IMainNavigator {
        return MainNavigator(activity.supportFragmentManager)
    }
}