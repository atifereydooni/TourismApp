package com.aferi.placelist.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PlaceList(
    onItemClick: () -> Unit
) {
    Column {
        Text(text = "First Page")
        Button(onClick = onItemClick) {
            Text(text = "Navigate to the second page")
        }
    }
}