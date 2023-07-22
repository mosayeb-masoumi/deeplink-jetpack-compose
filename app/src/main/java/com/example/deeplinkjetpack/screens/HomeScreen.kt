package com.example.deeplinkjetpack.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.deeplinkjetpack.Destination

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Green.copy(alpha = 0.4f)),
    contentAlignment = Alignment.Center){

            Text(text = "home screen")

    }
}