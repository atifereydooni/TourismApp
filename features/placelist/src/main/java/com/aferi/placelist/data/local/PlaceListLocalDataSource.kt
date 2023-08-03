package com.aferi.placelist.data.local

import com.aferi.placelist.data.local.database.PlaceDao
import com.aferi.placelist.data.model.PlaceLocalModel
import javax.inject.Inject

interface PlaceListLocalDataSource {
    suspend fun getPlaceList(): List<PlaceLocalModel>
    suspend fun insertPlaces(places: List<PlaceLocalModel>)
}

class PlaceListLocalDataSourceImpl @Inject constructor(
    private val placeDao: PlaceDao
) : PlaceListLocalDataSource {
    override suspend fun getPlaceList(): List<PlaceLocalModel> {
        return placeDao.getPlaces()
    }

    override suspend fun insertPlaces(places: List<PlaceLocalModel>) {
        placeDao.insertPlaces(places)
    }
}