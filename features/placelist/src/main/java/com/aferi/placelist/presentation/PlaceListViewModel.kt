package com.aferi.placelist.presentation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class PlaceListViewModel(
    private val navController: NavController
) : ViewModel() {

    fun navigateToPlaceDetailsScreen() {
        navController.navigate("PlaceDetails")
    }

}