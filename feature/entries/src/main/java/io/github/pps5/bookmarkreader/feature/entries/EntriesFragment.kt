package io.github.pps5.bookmarkreader.feature.entries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.DaggerFragment
import io.github.pps5.bookmarkreader.entity.Entry
import io.github.pps5.feature.entries.databinding.FragmentEntriesBinding

class EntriesFragment : DaggerFragment() {

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
        val entries = (0 until 100).map { i ->
            Entry(
                title = "title $i",
                link = "",
                subjects = listOf(),
                imageUrl = null,
                bookmarkCount = 0
            )
        }
            .map { EntryItem(it) }
        adapter.addAll(entries)
        binding.container.layoutManager = LinearLayoutManager(context)
        binding.container.adapter = adapter
    }
}
