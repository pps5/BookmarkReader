package io.github.pps5.bookmarkreader.feature.entries

import io.github.pps5.bookmarkreader.core.navigator.IMainNavigator
import javax.inject.Inject

class EntriesNavigator @Inject constructor(
    private val mainNavigator: IMainNavigator
) {
   fun navigateToWebViewFragment(url: String) {
       mainNavigator.navigateToWebViewFragment(url)
   }
}