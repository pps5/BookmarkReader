package io.github.pps5.bookmarkreader.data

import dagger.Module
import io.github.pps5.bookmarkreader.data.api.di.ApiModule
import io.github.pps5.bookmarkreader.data.repository.di.RepositoryModule

@Module(
    includes = [
        ApiModule::class,
        RepositoryModule::class
    ]
)
class DataModule
