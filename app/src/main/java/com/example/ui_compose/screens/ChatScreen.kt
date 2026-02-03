package com.example.ui_compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_compose.component.ButtonSend
import com.example.ui_compose.component.ChatAppTopBar

@Composable
fun ChatScreen(){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ChatAppTopBar()
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(Color.White)
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier.weight(8f)

                    ) {

                    }
                    BottomSection(
                        modifier = Modifier.weight(2f)
                    )

                }
            }
        }
    )

}


@Composable
private fun BottomSection(
    modifier: Modifier = Modifier
){
    var commandTxt by remember { mutableStateOf("") }

    Box(
        modifier = modifier.fillMaxWidth()
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp), clip = false)
            .background(color = Color.White, shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            .padding(10.dp)
    ){
        Column {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newTxt ->
                    commandTxt = newTxt
                },
                value = commandTxt,
                placeholder = {
                    Text(
                        text = "Ask me anything",
                        color = Color.LightGray
                    )
                }
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                ButtonSend {  }
                ButtonSend {  }
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
private fun BoxPrev() {
    BottomSection()
}