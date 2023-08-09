package com.aferi.placelist.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.aferi.component.TourismAppToolbar
import com.aferi.placelist.data.model.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    places: List<Place>,
    onItemClick: (NavController, Place) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TourismAppToolbar(
                scrollBehavior,
                Icons.Default.Menu,
                {}
            )
        }
    ) { values ->
        PlaceList(
            modifier = Modifier
                .fillMaxSize()
                .padding(values),
            navController = navController,
            places = places,
            onItemClick = onItemClick
        )
    }
}