package io.github.pps5.bookmarkreader.core.navigator

interface IMainNavigator {
    fun navigateToHomeFragment()
    fun navigateToWebViewFragment(url: String)
}
