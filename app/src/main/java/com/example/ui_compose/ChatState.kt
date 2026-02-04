package com.example.ui_compose

import androidx.compose.runtime.Immutable
import com.example.ui_compose.model.ChatItemModel

@Immutable
data class ChatState(
    var isLoading : Boolean = false,
    var chatList : List<ChatItemModel> = emptyList(),
    var errorMsg : String = ""
)