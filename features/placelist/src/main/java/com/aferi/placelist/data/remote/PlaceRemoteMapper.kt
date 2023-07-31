package com.aferi.placelist.data.remote

import com.aferi.placelist.data.model.Place
import com.google.firebase.firestore.DocumentSnapshot

class PlaceRemoteMapper {
    fun mapPlaces(places: List<DocumentSnapshot>)
            : List<Place> = places.map {
        Place(id = (it.data?.get("Id") as Long))
    }
}