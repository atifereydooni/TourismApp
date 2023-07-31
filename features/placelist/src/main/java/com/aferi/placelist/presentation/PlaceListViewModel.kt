package com.aferi.placelist.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.aferi.placelist.data.model.Place
import com.aferi.placelist.domain.GetPlaceListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceListViewModel @Inject constructor(
    private val placeListUseCase: GetPlaceListUseCase
) : ViewModel() {

    val places: MutableState<List<Place>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch {
            placeListUseCase.getPlaceList()
                .collect {
                    when {
                        it.isFailure -> {

                        }

                        it.isSuccess -> {
                            places.value = it.getOrNull()!!
                        }
                    }
                }
        }
    }

    fun navigateToPlaceDetailsScreen(navController: NavController) {
        navController.navigate("PlaceDetails")
    }

}