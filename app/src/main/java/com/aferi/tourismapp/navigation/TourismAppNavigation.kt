package com.aferi.tourismapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aferi.placedetails.PlaceDetails
import com.aferi.placelist.PlaceList

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
            PlaceList(navController = navController)
        }
        composable("PlaceDetails") { PlaceDetails() }
    }
}