package io.github.pps5.bookmarkreader.feature.home

import android.os.Bundle
import android.view.View
import io.github.pps5.bookmarkreader.core.di.fragment.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment(R.layout.fragment_home) {

    @Inject
    lateinit var homeNavigator: HomeNavigator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeNavigator.navigateToHotEntriesFragment()
    }

}