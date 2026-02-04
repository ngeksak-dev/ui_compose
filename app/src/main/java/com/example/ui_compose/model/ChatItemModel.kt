package com.example.ui_compose.model

import androidx.compose.runtime.Immutable
import java.util.UUID


@Immutable
sealed interface ChatItemModel {
    val id: String

    @Immutable
    data class User(
        override val id: String = UUID.randomUUID().toString(),
        val text: String
    ) : ChatItemModel

    @Immutable
    data class AI(
        override val id: String = UUID.randomUUID().toString(),
        val text: String
    ) : ChatItemModel

    @Immutable
    data class Loading(
        override val id: String = "loading"
    ) : ChatItemModel
}
