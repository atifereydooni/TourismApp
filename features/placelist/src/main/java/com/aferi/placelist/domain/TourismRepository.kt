package com.aferi.placelist.domain

import com.aferi.placelist.data.model.Place
import kotlinx.coroutines.flow.Flow

interface TourismRepository {

    suspend fun getPlaceList(): Flow<Result<List<Place>>>
}