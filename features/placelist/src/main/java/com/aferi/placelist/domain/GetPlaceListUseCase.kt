package com.aferi.placelist.domain

import com.aferi.placelist.data.model.Place
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlaceListUseCase @Inject constructor(
    private val placeListRepository: PlaceListRepository
) {

    suspend fun getPlaceList(): Flow<Result<List<Place>>> {
        return placeListRepository.getPlaceList()
    }
}