package io.github.pps5.bookmarkreader.di

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import io.github.pps5.bookmarkreader.MainActivity

@Module
abstract class MainActivityModule {
    @Binds
    abstract fun bindsActivity(activity: MainActivity) : AppCompatActivity
}