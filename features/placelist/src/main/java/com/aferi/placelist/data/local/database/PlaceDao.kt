package com.aferi.placelist.data.local.database

import androidx.room.*
import com.aferi.placelist.data.model.PlaceLocalModel

@Dao
interface PlaceDao {

    @Query("select * from place")
    fun getPlaces(): List<PlaceLocalModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaces(places: List<PlaceLocalModel>)
}
