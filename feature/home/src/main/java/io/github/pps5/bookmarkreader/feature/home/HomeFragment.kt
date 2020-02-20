package io.github.pps5.bookmarkreader.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import io.github.pps5.bookmarkreader.feature.home.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var homeNavigator: HomeNavigator
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeNavigator.navigateToHotEntriesFragment()
    }
}