package com.aferi.placelist.data.remote

import com.aferi.placelist.data.model.Place
import com.google.firebase.firestore.DocumentSnapshot

class PlaceRemoteMapper {
    fun mapPlaces(places: List<DocumentSnapshot>)
            : List<Place> = places.map {
        Place(
            id = it.data?.get("Id") as Long,
            title = it.data?.get("Title") as String,
            subtitle = it.data?.get("Subtitle") as String,
            description = it.data?.get("Description") as String,
            imageUrl = it.data?.get("ImageUrl") as String,
        )
    }
}