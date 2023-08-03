package com.aferi.placelist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aferi.placelist.data.model.PlaceLocalModel


// TODO Database: Uncomment and define database entities, converters, and dto
@Database(entities = [PlaceLocalModel::class], version = 1, exportSchema = false)
// @TypeConverters()
abstract class AppDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao
}
