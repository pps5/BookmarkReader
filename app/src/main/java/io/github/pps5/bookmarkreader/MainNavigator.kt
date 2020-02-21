package io.github.pps5.bookmarkreader

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import io.github.pps5.bookmarkreader.core.navigator.IMainNavigator
import io.github.pps5.bookmarkreader.feature.entries.fragment.WebViewFragment
import io.github.pps5.bookmarkreader.feature.home.HomeFragment
import javax.inject.Inject

class MainNavigator @Inject constructor(
    private val fragmentManager: FragmentManager
) : IMainNavigator {

    private val containerId = R.id.container

    override fun navigateToHomeFragment() {
        fragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .commit()
    }

    override fun navigateToWebViewFragment(url: String) {
        val fragment = fragmentManager.findFragmentById(containerId)!!
        fragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .hide(fragment)
            .add(containerId, WebViewFragment.newInstance(url))
            .addToBackStack(null)
            .commit()
    }
}