package io.github.pps5.bookmarkreader.data.api.entity

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml
import io.github.pps5.bookmarkreader.entity.IEntry

@Xml
data class Item(
    @PropertyElement(name = "title")
    override val title: String,

    @PropertyElement(name = "link")
    override val link: String,

    @Element(name = "dc:subject")
    val subjects: List<Subject>?,

    @PropertyElement(name = "hatena:imageurl")
    override val imageUrl: String?,

    @PropertyElement(name = "hatena:bookmarkcount")
    override val bookmarkCount: Int
): IEntry
