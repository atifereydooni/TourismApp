package com.aferi.placelist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.aferi.placelist.data.model.Place

@Composable
fun PlaceList(
    modifier: Modifier,
    navController: NavController,
    places: List<Place>,
    onItemClick: (NavController, Place) -> Unit
) {
    Column {
        LazyColumn {
            items(places) { place ->
                PlaceItem(
                    place = place,
                    navController = navController,
                    onItemClick = onItemClick
                )
            }
        }
    }
}