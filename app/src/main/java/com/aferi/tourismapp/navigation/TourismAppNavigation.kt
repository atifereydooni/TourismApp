package com.aferi.tourismapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
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
            val viewModel: PlaceListViewModel = hiltViewModel()
            PlaceList(
                navController = navController,
                places = viewModel.places.collectAsState().value,
                onItemClick = viewModel::navigateToPlaceDetailsScreen
            )
        }
        composable("PlaceDetails") { PlaceDetails() }
    }
}