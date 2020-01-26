package io.github.pps5.bookmarkreader.data.api.entity

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "rdf:RDF")
data class Entries (
    @Element(name = "item")
    val items: List<Item>
)
