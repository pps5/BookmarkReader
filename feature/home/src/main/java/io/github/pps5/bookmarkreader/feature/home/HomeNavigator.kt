package io.github.pps5.bookmarkreader.feature.home

import androidx.fragment.app.FragmentManager
import io.github.pps5.bookmarkreader.feature.entries.fragment.HotEntriesFragment
import javax.inject.Inject

class HomeNavigator @Inject constructor(
    private val fragmentManager: FragmentManager
) {

    fun navigateToHotEntriesFragment(){
        fragmentManager.beginTransaction()
            .replace(R.id.home_container, HotEntriesFragment())
            .commit()
    }
}