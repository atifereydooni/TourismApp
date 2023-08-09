package com.aferi.placedetails.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.aferi.component.RatingBar
import com.aferi.component.TourismAppToolbar
import com.aferi.placedetails.data.model.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetails(
    navController: NavController,
    place: Place
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TourismAppToolbar(
                scrollBehavior,
                Icons.Default.ArrowBack
            ) {
                navController.navigateUp()
            }
        }
    ) { values ->
        PlaceDetailContent(
            modifier = Modifier.padding(values),
            place = place
        )
    }
}

@Composable
fun PlaceDetailContent(
    modifier: Modifier,
    place: Place
) {
    Column(
        modifier = modifier
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
                    .height(250.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
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
            modifier = Modifier
                .padding(PaddingValues(10.dp, 10.dp, 10.dp, 0.dp)),
            text = place.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
            )
        )
        Text(
            modifier = Modifier
                .padding(PaddingValues(10.dp, 0.dp, 10.dp, 0.dp)),
            text = place.subtitle,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
            )
        )
        Text(
            modifier = Modifier
                .padding(PaddingValues(10.dp, 5.dp, 10.dp, 0.dp))
                .verticalScroll(rememberScrollState(0)),
            text = place.description,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 16.sp,
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}