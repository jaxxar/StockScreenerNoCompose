package com.example.stockscreenernocompose.di

import com.example.stockscreenernocompose.utils.network.Repository
import com.example.stockscreenernocompose.utils.network.StocksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(
        retrofit: Retrofit
    ): Repository {
        return Repository(retrofit.create(StocksAPI::class.java))
    }
}