package com.example.ui_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ui_compose.screens.HomeScreen
import com.example.ui_compose.ui.theme.Ui_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ui_ComposeTheme {
                HomeScreen()
            }
        }
    }
}