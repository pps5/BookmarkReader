package io.github.pps5.bookmarkreader.data.repository.mapper

import io.github.pps5.bookmarkreader.data.api.entity.FeedCategory
import io.github.pps5.bookmarkreader.entity.Category

internal fun Category.toFeedCategory(): FeedCategory =
    FeedCategory.valueOf(this.name)
