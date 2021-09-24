package com.example.stockscreenernocompose.di

import com.example.stockscreenernocompose.utils.Constants
import com.example.stockscreenernocompose.utils.network.StocksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkService(httpClient: OkHttpClient.Builder): StocksAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(StocksAPI::class.java)
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
    }
}