package com.example.ui_compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.ui_compose.helper.noRippleClickable
import com.example.ui_compose.model.HomeMenuModel

@Composable
fun HomeMenuItem(
    menuModel : HomeMenuModel,
    onclick : () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .dropShadow(shape = RoundedCornerShape(25.dp), shadow = Shadow(
                radius = 10.dp,
                spread = 0.0.dp,
                color = Color.Black.copy(0.1f)
            ))
            .background(color = Color.White, shape = RoundedCornerShape(25.dp))
            .noRippleClickable(
                onClick = onclick
            )
            .padding(horizontal = 10.dp, vertical = 25.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                modifier = Modifier.size(35.dp),
                painter = painterResource(menuModel.iconName),
                contentDescription = "Icon Menu",
                colorFilter = ColorFilter.tint(Color.Black),
                contentScale = ContentScale.Fit
            )
            Text(
                text = menuModel.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = menuModel.subTitle,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}