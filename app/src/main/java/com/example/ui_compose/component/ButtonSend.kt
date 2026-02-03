package com.example.ui_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import com.example.ui_compose.R

@Composable
fun ButtonSend(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .padding(10.dp)
            .clickable(
                onClick = onClick
            )
    ){
        Row {
            Text(
                text = "Send",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(5.dp))
            Image(
                modifier = Modifier.size(25.dp),
                painter = painterResource(R.drawable.arrowup),
                contentDescription = "Up",
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}
