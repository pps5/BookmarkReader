package io.github.pps5.bookmarkreader.feature.entries.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.DaggerFragment
import io.github.pps5.bookmarkreader.feature.entries.EntriesNavigator
import io.github.pps5.bookmarkreader.feature.entries.view.item.EntryItem
import io.github.pps5.bookmarkreader.feature.entries.viewmodel.EntriesViewModel
import io.github.pps5.feature.entries.databinding.FragmentEntriesBinding
import javax.inject.Inject

class EntriesFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: EntriesNavigator

    private val viewModel: EntriesViewModel by viewModels { factory }
    private lateinit var binding: FragmentEntriesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEntriesBinding.inflate(
            LayoutInflater.from(context), container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
