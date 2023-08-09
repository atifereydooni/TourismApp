package com.aferi.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TourismAppToolbar(
    scrollBehavior: TopAppBarScrollBehavior,
    navigationIcon: ImageVector,
    navigationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Stockholm Tourism")
        },
        navigationIcon = {
            IconButton(onClick = { navigationIconClick }) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = "Menu Icon"
                )
            }
        },
        actions = {

        },
        scrollBehavior = scrollBehavior
    )
}