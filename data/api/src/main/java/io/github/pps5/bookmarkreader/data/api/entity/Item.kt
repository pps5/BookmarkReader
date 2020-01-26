package io.github.pps5.bookmarkreader.data.api.entity

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Item(
    @PropertyElement(name = "title")
    val title: String,

    @PropertyElement(name = "link")
    val link: String,

    @Element(name = "dc:subject")
    val subjects: List<Subject>?,

    @PropertyElement(name = "hatena:imageurl")
    val imageUrl: String?,

    @PropertyElement(name = "hatena:bookmarkcount")
    val bookmarkCount: Int
)
