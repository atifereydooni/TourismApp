package com.aferi.placelist.data

import com.aferi.placelist.data.local.PlaceListLocalDataSource
import com.aferi.placelist.data.model.Place
import com.aferi.placelist.data.model.PlaceLocalModel
import com.aferi.placelist.data.remote.PlaceListRemoteDataSource
import com.aferi.placelist.domain.PlaceListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaceListRepositoryImpl @Inject constructor(
    private val placeListRemoteDataSource: PlaceListRemoteDataSource,
    private val placeListLocalDataSource: PlaceListLocalDataSource
) : PlaceListRepository {

    override suspend fun getPlaceList(): Flow<Result<List<Place>>> = flow {
        val localPlaces = placeListLocalDataSource.getPlaceList().map { place ->
            Place(
                id = place.id,
                title = place.title,
                subtitle = place.subtitle,
                description = place.description,
                imageUrl = place.imageUrl,
                rate = place.rate
            )
        }
        if (localPlaces.isNotEmpty()) {
            emit(Result.success(localPlaces))
        } else {
            val remotePlaces = placeListRemoteDataSource.getPlaceList()
            remotePlaces.collect {
                when {
                    it.isSuccess -> {
                        placeListLocalDataSource.insertPlaces(it.getOrNull()!!.map { place ->
                            PlaceLocalModel(
                                id = place.id,
                                title = place.title,
                                subtitle = place.subtitle,
                                description = place.description,
                                imageUrl = place.imageUrl,
                                rate = place.rate
                            )
                        })
                        emit(it)
                    }

                    it.isFailure -> {
                        Result.failure<List<Place>>(it.exceptionOrNull()!!)
                    }
                }
            }
        }
    }
}