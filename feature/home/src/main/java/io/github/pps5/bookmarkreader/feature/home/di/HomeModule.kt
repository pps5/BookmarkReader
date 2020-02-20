package io.github.pps5.bookmarkreader.feature.home.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.github.pps5.bookmarkreader.feature.home.HomeFragment

@Module
abstract class HomeModule {

    @Binds
    abstract fun bindsFragment(fragment: HomeFragment): Fragment

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideFragmentManager(fragment: Fragment): FragmentManager {
            return fragment.childFragmentManager
        }
    }

}