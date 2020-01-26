package io.github.pps5.bookmarkreader.data.api.di

import android.util.Log
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.converter.htmlescape.HtmlEscapeStringConverter
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.Module
import dagger.Provides
import io.github.pps5.bookmarkreader.data.api.FeedClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                Log.d("dbg", it.request().url.toString())
                it.proceed(it.request())
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideTikXml(): TikXml {
        return TikXml.Builder()
            .addTypeConverter(String::class.java, HtmlEscapeStringConverter())
            .exceptionOnUnreadXml(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideFeedClient(
        okHttpClient: OkHttpClient,
        tikXml: TikXml
    ): FeedClient {
        return Retrofit.Builder()
            .baseUrl("https://b.hatena.ne.jp/")
            .client(okHttpClient)
            .addConverterFactory(TikXmlConverterFactory.create(tikXml))
            .build()
            .create(FeedClient::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideFeedClient(
//        context: Context,
//        okHttpClient: OkHttpClient,
//        tikXml: TikXml
//    ): FeedClient {
//        return FeedClientImpl(context, okHttpClient, tikXml)
//    }
}