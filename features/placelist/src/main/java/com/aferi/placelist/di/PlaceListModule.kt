package com.aferi.placelist.di

import com.aferi.placelist.data.PlaceListRepositoryImpl
import com.aferi.placelist.data.local.PlaceListLocalDataSource
import com.aferi.placelist.data.local.PlaceListLocalDataSourceImpl
import com.aferi.placelist.data.remote.PlaceListRemoteDataSource
import com.aferi.placelist.data.remote.PlaceListRemoteDataSourceImpl
import com.aferi.placelist.domain.PlaceListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PlaceListModule {

    @Binds
    abstract fun providePlaceListRemoteDataSource(
        placeListRemoteDataSource: PlaceListRemoteDataSourceImpl
    ): PlaceListRemoteDataSource

    @Binds
    abstract fun providePlaceListLocalDataSource(
        placeListLocalDataSource: PlaceListLocalDataSourceImpl
    ): PlaceListLocalDataSource

    @Binds
    abstract fun providePlaceListRepository(
        placeListRepository: PlaceListRepositoryImpl
    ): PlaceListRepository
}