package io.github.pps5.bookmarkreader.feature.entries.view.item

import com.xwray.groupie.databinding.BindableItem
import io.github.pps5.bookmarkreader.entity.IEntry
import io.github.pps5.feature.entries.R
import io.github.pps5.feature.entries.databinding.EntryItemBinding


class EntryItem(
    private val entry: IEntry,
    private val onClickListener: (IEntry) -> Unit
) : BindableItem<EntryItemBinding>() {

    override fun getLayout(): Int = R.layout.entry_item

    override fun bind(viewBinding: EntryItemBinding, position: Int) {
        viewBinding.entry = entry
        viewBinding.root.setOnClickListener {
            onClickListener(entry)
        }
    }
}