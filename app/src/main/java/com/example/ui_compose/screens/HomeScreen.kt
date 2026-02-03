package com.example.ui_compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_compose.R
import com.example.ui_compose.component.HomeAppTopBar
import com.example.ui_compose.component.HomeMenuItem
import com.example.ui_compose.model.HomeMenuModel

@Composable
fun HomeScreen(){

    val menuList = listOf(
        HomeMenuModel(id = 1, title = "Ask AI", subTitle = "ask me anything", iconName = R.drawable.chat),
        HomeMenuModel(id = 2, title = "Generate Image", subTitle = "generate image", iconName = R.drawable.img),
        HomeMenuModel(id = 3, title = "History", subTitle = "view all your history", iconName = R.drawable.time),
        HomeMenuModel(id = 4, title = "Image to Code", subTitle = "convert image to code", iconName = R.drawable.code)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HomeAppTopBar()
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 20.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.weight(0.3f))
                    Text(
                        text = "Hi Zakk,",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "How ,can I assist you today?",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(vertical = 20.dp),
                        columns = GridCells.Fixed(2),
                        horizontalArrangement = Arrangement.spacedBy(15.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        item(span = { GridItemSpan(maxLineSpan) }) {

                        }
                        items(menuList.size,key = {menuList[it].id}) { index ->
                            HomeMenuItem(menuModel = menuList[index])
                        }
                    }
                    Spacer(modifier = Modifier.weight(0.5f))
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    HomeScreen()
}