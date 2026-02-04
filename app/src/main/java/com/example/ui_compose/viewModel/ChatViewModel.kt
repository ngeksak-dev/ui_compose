package com.example.ui_compose.viewModel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.ui_compose.ChatState
import com.example.ui_compose.event.ChatEvent
import com.example.ui_compose.model.ChatItemModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChatViewModel : ScreenModel {

    private val _chatState = MutableStateFlow(ChatState())
    val chatState: StateFlow<ChatState> = _chatState

    fun handleEvent(event: ChatEvent) {
        when (event) {
            is ChatEvent.onAskAi -> addConversation(event.txtChat, lang = event.lang)
        }
    }

    private fun addConversation(txtChat: String,lang : String) {
        screenModelScope.launch {

            addUserChat(txtChat)

            addLoading()

            delay(1500)

            if (lang == "English"){
                when(txtChat){
                    "Hi","Hello" -> replaceLoadingWithAi("Hello, How can I help you Today")
                    "I want learn code" -> replaceLoadingWithAi("Sure, I can help you with that.What language you want to learn")
                    else -> replaceLoadingWithAi("Sorry I'm not available now")
                }
            }else{
                when(txtChat){
                    "សួស្តី" -> replaceLoadingWithAi("តើមានអ្វីខ្ញុំអាចជួយបានទេ")
                    "រៀនកូត" -> replaceLoadingWithAi("តើអ្នកចង់រៀនភាសាអ្វីដែរ?")
                    else -> {
                        replaceLoadingWithAi("សូមអធ្យាស្រ័យ ប្រព័ន្ធកំពុងមានបញ្ហា")
                    }
                }
            }
        }
    }

    private fun addUserChat(text: String) {
        _chatState.update { state ->
            state.copy(
                chatList = state.chatList + ChatItemModel.User(text = text)
            )
        }
    }

    private fun addLoading() {
        _chatState.update { state ->
            state.copy(
                chatList = state.chatList + ChatItemModel.Loading()
            )
        }
    }

    private fun replaceLoadingWithAi(text: String) {
        _chatState.update { state ->
            state.copy(
                chatList = state.chatList.dropLast(1) + ChatItemModel.AI(text =text)
            )
        }
    }
}
