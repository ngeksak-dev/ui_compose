package com.example.ui_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_compose.R

@Composable
fun AiChat(
    txtChat : String,
    onCopy : () -> Unit,
    onRead : () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ){
        Column {
            Text(
                text = txtChat,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .clickable(
                            onClick = {
                                onCopy
                            }
                        ),
                    painter = painterResource(R.drawable.copy),
                    contentDescription = "Copy",
                    colorFilter = ColorFilter.tint(Color.Black)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Image(
                    modifier = Modifier
                        .size(25.dp)
                        .clickable(
                            onClick = {
                                onRead
                            }
                        ),
                    painter = painterResource(R.drawable.sound),
                    contentDescription = "Copy",
                    colorFilter = ColorFilter.tint(Color.Black)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AiChatPrev() {
    AiChat(txtChat = "Hello,How are you", onCopy = {}) { }
}