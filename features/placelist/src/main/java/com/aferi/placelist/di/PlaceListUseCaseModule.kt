package com.aferi.placelist.di

import com.aferi.placelist.domain.GetPlaceListUseCase
import com.aferi.placelist.domain.PlaceListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PlaceListUseCaseModule {

    @Provides
    fun provideGetAllRoomUseCase(placeListRepository: PlaceListRepository): GetPlaceListUseCase {
        return GetPlaceListUseCase(placeListRepository = placeListRepository)
    }
}