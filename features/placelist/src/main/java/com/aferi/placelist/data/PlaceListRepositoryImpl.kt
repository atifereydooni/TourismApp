package com.aferi.placelist.data

import com.aferi.placelist.data.local.PlaceListLocalDataSource
import com.aferi.placelist.data.model.Place
import com.aferi.placelist.data.remote.PlaceListRemoteDataSource
import com.aferi.placelist.domain.PlaceListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaceListRepositoryImpl @Inject constructor(
    private val placeListRemoteDataSource: PlaceListRemoteDataSource,
    private val placeListLocalDataSource: PlaceListLocalDataSource
) : PlaceListRepository {

    override suspend fun getPlaceList(): Flow<Result<List<Place>>> {
        return placeListRemoteDataSource.getPlaceList()
    }
}