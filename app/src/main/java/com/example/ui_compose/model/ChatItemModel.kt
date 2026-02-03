package com.example.ui_compose.model

data class ChatItemModel(
    val id : String,
    val isSender : Boolean,
    val text : String,
    val lang : String
)