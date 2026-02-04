package com.example.ui_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.ui_compose.R

@Composable
fun HomeAppTopBar(){

    val navigator = LocalNavigator.currentOrThrow

    Box (
        modifier = Modifier
            .background(Color.White)
            .padding(top = 40.dp)
            .fillMaxWidth()
    ){
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier.size(25.dp)
                    .clickable(
                        onClick = {
                            navigator.pop()
                        }
                    ),
                painter = painterResource(R.drawable.menu),
                contentDescription = "aaa",
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(Color.Black)
            )

            Image(
                modifier = Modifier.size(75.dp),
                painter = painterResource(R.drawable.iconapp),
                contentDescription = "aaa",
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(Color.Black)
            )

            Image(
                modifier = Modifier.size(25.dp),
                painter = painterResource(R.drawable.bell),
                contentDescription = "aaa",
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(Color.Black)
            )
        }
    }
}