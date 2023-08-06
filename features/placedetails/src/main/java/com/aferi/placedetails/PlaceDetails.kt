package com.aferi.placedetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.aferi.component.TourismAppToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetails() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TourismAppToolbar(
                scrollBehavior,
                Icons.Default.ArrowBack,
                {}
            )
        }
    ) { values ->
        Text(
            modifier = Modifier.padding(values),
            text = "Place Details"
        )
    }
}