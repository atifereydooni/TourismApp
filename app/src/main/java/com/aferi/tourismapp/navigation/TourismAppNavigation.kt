package com.aferi.tourismapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aferi.placedetails.PlaceDetails
import com.aferi.placelist.presentation.PlaceList
import com.aferi.placelist.presentation.PlaceListViewModel

@Composable
fun TourismAppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "PlaceList",
        modifier = modifier
    ) {
        composable("PlaceList") {
            val viewModel = PlaceListViewModel(navController)
            PlaceList(onItemClick = viewModel::navigateToPlaceDetailsScreen)
        }
        composable("PlaceDetails") { PlaceDetails() }
    }
}