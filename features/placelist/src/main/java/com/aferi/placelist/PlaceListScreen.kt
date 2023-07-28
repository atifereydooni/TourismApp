package com.aferi.placelist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun PlaceList(
    navController: NavController
) {
    Column {
        Text(text = "First Page")
        Button(onClick = {
            navController.navigate("PlaceDetails")
        }) {
            Text(text = "Navigate to the second page")
        }
    }
}