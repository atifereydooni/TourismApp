package com.aferi.placelist.data

import com.aferi.placelist.data.local.TourismLocalDataSource
import com.aferi.placelist.data.model.Place
import com.aferi.placelist.data.remote.TourismRemoteDataSource
import com.aferi.placelist.domain.TourismRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaceListRepositoryImpl @Inject constructor(
    private val tourismRemoteDataSource: TourismRemoteDataSource,
    private val tourismLocalDataSource: TourismLocalDataSource
) : TourismRepository {

    override suspend fun getPlaceList(): Flow<Result<List<Place>>> {
        TODO("Not yet implemented")
    }
}