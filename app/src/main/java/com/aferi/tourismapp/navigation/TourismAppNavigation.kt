package com.aferi.tourismapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aferi.placedetails.data.model.Place
import com.aferi.placedetails.presentation.PlaceDetails
import com.aferi.placelist.presentation.MainScreen
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
            MainScreen(
                navController = navController,
                places = viewModel.places.collectAsState().value,
                onItemClick = viewModel::navigateToPlaceDetailsScreen
            )
        }
        composable(
            "PlaceDetails/{placeId}/{placeTitle}/{placeSubtitle}/{placeDescription}/{placeImageUrl}/{placeRate}",
            arguments = listOf(navArgument("placeId") {
                type = NavType.LongType
            }, navArgument("placeTitle") {
                type = NavType.StringType
            }, navArgument("placeSubtitle") {
                type = NavType.StringType
            }, navArgument("placeDescription") {
                type = NavType.StringType
            }, navArgument("placeImageUrl") {
                type = NavType.StringType
            }, navArgument("placeRate") {
                type = NavType.StringType
            })
        ) {
            PlaceDetails(
                navController, Place(
                    id = it.arguments?.getLong("placeId")!!,
                    title = it.arguments?.getString("placeTitle")!!,
                    subtitle = it.arguments?.getString("placeSubtitle")!!,
                    description = it.arguments?.getString("placeDescription")!!,
                    imageUrl = it.arguments?.getString("placeImageUrl")!!.replace("$$$", "/"),
                    rate = it.arguments?.getString("placeRate")!!,
                )
            )
        }
    }
}