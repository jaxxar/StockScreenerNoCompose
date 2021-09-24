package com.example.stockscreenernocompose.di

import com.example.stockscreenernocompose.utils.network.Repository
import com.example.stockscreenernocompose.utils.network.StocksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(
        api: StocksAPI
    ): Repository {
        return Repository(api)
    }
}