package io.github.pps5.bookmarkreader

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.github.pps5.bookmarkreader.core.navigator.IMainNavigator
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mainNavigator: IMainNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainNavigator.navigateToHomeFragment()
    }
}
