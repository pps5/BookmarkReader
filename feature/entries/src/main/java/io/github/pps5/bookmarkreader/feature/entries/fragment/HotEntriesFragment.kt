package io.github.pps5.bookmarkreader.feature.entries.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import io.github.pps5.bookmarkreader.entity.Category
import io.github.pps5.feature.entries.R
import io.github.pps5.feature.entries.databinding.FragmentHotEntriesBinding

class HotEntriesFragment : Fragment(R.layout.fragment_hot_entries) {

    private lateinit var adapter: PagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentHotEntriesBinding.bind(view)
        adapter = PagerAdapter(this)
        binding.pager.adapter = adapter
        TabLayoutMediator(binding.tab, binding.pager) { tab, position ->
            tab.text = Category.fromTabIndex(position).title
        }.attach()
    }

    private class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        private val categoryCount = Category.values().size
        override fun getItemCount(): Int = categoryCount

        override fun createFragment(position: Int): Fragment {
            return EntriesFragment.newInstance(Category.fromTabIndex(position))
        }

    }
}