package io.github.pps5.bookmarkreader.feature.entries

import com.xwray.groupie.databinding.BindableItem
import io.github.pps5.bookmarkreader.entity.Entry
import io.github.pps5.feature.entries.R
import io.github.pps5.feature.entries.databinding.EntryItemBinding


class EntryItem(
    private val entry: Entry
) : BindableItem<EntryItemBinding>() {

    override fun getLayout(): Int = R.layout.entry_item

    override fun bind(viewBinding: EntryItemBinding, position: Int) {
        viewBinding.entry = entry
    }
}