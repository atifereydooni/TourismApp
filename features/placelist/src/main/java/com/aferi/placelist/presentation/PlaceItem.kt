package com.aferi.placelist.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.aferi.placelist.data.model.Place

@Composable
fun PlaceItem(
    modifier: Modifier = Modifier,
    place: Place,
    navController: NavController,
    onItemClick: (NavController) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                onItemClick(navController)
            }
    ) {
        Box(
            modifier = Modifier
        ) {
            AsyncImage(
                model = place.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Color.DarkGray,
                            )
                        )
                    )
            )
            if (place.rate.toDouble() >= 0)
                RatingBar(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(10.dp),
                    rating = place.rate.toDouble()
                )
        }
        Text(
            text = place.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
            )
        )
        Text(
            text = place.subtitle,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
            )
        )
        Text(
            text = place.description,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp,
            ),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}