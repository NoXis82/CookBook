package com.noxis.presentation.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

sealed class UiText {
    data class DynamicString(val text: String) : UiText()
    class StringResource(
        @StringRes val resId: Int,
        val args: Array<Any> = arrayOf()
    ) : UiText()

    @Composable
    @Suppress("SpreadOperator")
    fun asString(): String {
        return when (this) {
            is StringResource -> LocalContext.current.getString(resId, *args)
            is DynamicString -> text
        }
    }

    @Suppress("SpreadOperator")
    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> text
            is StringResource -> context.getString(resId, *args)
        }
    }
}
