package com.aferi.placelist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.aferi.placelist.data.remote.TourismRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceListViewModel @Inject constructor(
    private val tourismRemoteDataSource: TourismRemoteDataSource
) : ViewModel() {
    init {
        viewModelScope.launch {
            tourismRemoteDataSource.getPlaceList()
                .collect {
                    when {
                        it.isFailure -> {

                        }

                        else -> {

                        }
                    }
                }
        }
    }

    fun navigateToPlaceDetailsScreen(navController: NavController) {
        navController.navigate("PlaceDetails")
    }

}