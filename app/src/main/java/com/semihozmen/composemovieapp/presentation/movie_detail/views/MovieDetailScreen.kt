package com.semihozmen.composemovieapp.presentation.movie_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.semihozmen.composemovieapp.presentation.movie_detail.MovieDetailViewModel


@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
){

    val state = movieDetailViewModel.state

    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
    contentAlignment = Alignment.Center){
        
        state.value.movieDetail?.let {
            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = rememberImagePainter(data = it.Poster), contentDescription =it.Title,
                modifier = Modifier
                    .padding(16.dp)
                    .size(300.dp, 300.dp)
                    .clip(RectangleShape)
                    .align(CenterHorizontally))
                
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = it.Title,
                    color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp))
            }
        }

        if(state.value.error.isNotBlank()){
            Text(
                text = state.value.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center)
        }

        if(state.value.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Center))
        }
        
    }

}