package io.github.pps5.bookmarkreader.feature.entries.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import io.github.pps5.bookmarkreader.core.di.fragment.DaggerFragment
import io.github.pps5.bookmarkreader.feature.entries.EntriesNavigator
import io.github.pps5.bookmarkreader.feature.entries.view.item.EntryItem
import io.github.pps5.bookmarkreader.feature.entries.viewmodel.EntriesViewModel
import io.github.pps5.feature.entries.R
import io.github.pps5.feature.entries.databinding.FragmentEntriesBinding
import javax.inject.Inject

class EntriesFragment : DaggerFragment(R.layout.fragment_entries) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: EntriesNavigator

    private val viewModel: EntriesViewModel by viewModels { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentEntriesBinding.bind(view)
        val adapter = GroupAdapter<GroupieViewHolder>()
        binding.container.layoutManager = LinearLayoutManager(context)
        binding.container.adapter = adapter

        viewModel.model.observe(
            viewLifecycleOwner,
            Observer<EntriesViewModel.Model> { model ->
                adapter.update(model.entries.map {
                    EntryItem(
                        it
                    ) { e ->
                        navigator.navigateToWebViewFragment(e.link)
                    }
                })
            }
        )
    }
}
