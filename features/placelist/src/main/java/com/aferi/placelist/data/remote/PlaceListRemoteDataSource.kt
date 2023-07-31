package com.aferi.placelist.data.remote

import com.aferi.placelist.data.model.Place
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

interface TourismRemoteDataSource {

    suspend fun getPlaceList(): Flow<Result<List<Place>>>
}

class TourismRemoteDataSourceImpl @Inject constructor() : TourismRemoteDataSource {

    override suspend fun getPlaceList(): Flow<Result<List<Place>>> = callbackFlow {
        val fireStoreListener = EventListener<QuerySnapshot> { value, error ->
            val placeState = if (error != null) {
                Result.failure(Throwable(error.message))
            } else {
                if (value!!.isEmpty)
                    Result.failure(Throwable("NoData"))
                else {
                    value.let {
                        Result.success(PlaceRemoteMapper().mapPlaces(it.documents))
                    }
                }
            }
            trySend(placeState)
        }

        Firebase.firestore
            .collection("Place")
            .addSnapshotListener(fireStoreListener)
        awaitClose()
    }
}