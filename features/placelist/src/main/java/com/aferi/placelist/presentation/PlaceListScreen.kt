package com.aferi.placelist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun PlaceList(
    navController: NavController,
    onItemClick: (NavController) -> Unit
) {
    Column {
        Text(text = "First Page")
        Button(onClick = { onItemClick(navController) }) {
            Text(text = "Navigate to the second page")
        }
    }
}