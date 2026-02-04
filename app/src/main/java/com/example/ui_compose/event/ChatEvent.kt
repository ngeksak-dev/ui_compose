package com.example.ui_compose.event

sealed class ChatEvent {
    data class onAskAi(val txtChat : String, val lang : String) : ChatEvent()
}