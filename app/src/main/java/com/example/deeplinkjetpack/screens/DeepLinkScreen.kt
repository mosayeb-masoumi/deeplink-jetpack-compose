package com.example.deeplinkjetpack.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeepLinkScreen(id: Int?, age: Int?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green.copy(alpha = 0.4f)),
        contentAlignment = Alignment.Center
    ) {

        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "DeepLink page" , fontSize = 30.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "id= $id   age=$age")
        }

    }
}