package com.example.myapplication.features_note.presentation.create_modify_notes

import androidx.compose.ui.focus.FocusState

sealed class CreateModifyEvent{
    data class EnteredTitle(val value: String): CreateModifyEvent()
    data class ChangeTitleFocus(val focusState: FocusState): CreateModifyEvent()
    data class EnteredContent(val value: String): CreateModifyEvent()
    data class ChangeContentFocus(val focusState: FocusState): CreateModifyEvent()
    data class ChangeColor(val color: Int): CreateModifyEvent()
    object SaveNote: CreateModifyEvent()
}
