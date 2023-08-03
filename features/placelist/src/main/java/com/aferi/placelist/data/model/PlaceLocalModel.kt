package com.aferi.placelist.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Place")
data class PlaceLocalModel(
    @PrimaryKey
    val id: Long,
    val title: String,
    val subtitle: String,
    val description: String,
    val imageUrl: String,
    val rate: String,
)
