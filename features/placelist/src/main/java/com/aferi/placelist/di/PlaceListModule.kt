package com.aferi.placelist.di

import com.aferi.placelist.data.remote.TourismRemoteDataSource
import com.aferi.placelist.data.remote.TourismRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PlaceListModule {

    @Binds
    abstract fun provideTourismRemoteDataSource(
        tourismRemoteDataSource: TourismRemoteDataSourceImpl
    ): TourismRemoteDataSource
}