package com.aferi.placelist.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.aferi.placelist.data.model.Place

@Composable
fun PlaceList(
    navController: NavController,
    places: List<Place>,
    onItemClick: (NavController) -> Unit
) {
    Column {
        LazyColumn {
            items(places) { place ->
                Column(
                    modifier = Modifier.clickable {
                        onItemClick(navController)
                    }
                ) {
                    AsyncImage(
                        model = place.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    )
                    Text(
                        text = place.title,
                        style = TextStyle(
                            color = Black,
                            fontSize = 20.sp,
                        )
                    )
                    Text(
                        text = place.subtitle,
                        style = TextStyle(
                            color = Black,
                            fontSize = 18.sp,
                        )
                    )
                    Text(
                        text = place.description,
                        style = TextStyle(
                            color = Gray,
                            fontSize = 14.sp,
                        ),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}