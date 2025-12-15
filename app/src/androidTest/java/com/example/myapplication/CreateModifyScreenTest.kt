package com.example.myapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.features_note.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateModifyScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun clickAddNoteButton_opensCreateModifyScreen() {

        composeTestRule
            .onNodeWithTag("AddNoteButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("SaveNoteButton")
            .assertIsDisplayed()
    }

    @Test
    fun enterTitleTextField_acceptsInput() {

        composeTestRule
            .onNodeWithTag("AddNoteButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("TitleTextField")
            .performTextInput("Espresso Note")
    }


    @Test
    fun enterContentTextField_acceptsInput() {

        composeTestRule
            .onNodeWithTag("AddNoteButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("ContentTextField")
            .performTextInput("This is a test note")
    }

    @Test
    fun selectColorOption_doesNotCrash() {

        composeTestRule
            .onNodeWithTag("AddNoteButton")
            .performClick()

        repeat(4) { index ->
            composeTestRule
                .onNodeWithTag("ColorOption_$index")
                .assertExists()
                .performClick()
        }

        composeTestRule
            .onNodeWithTag("SaveNoteButton")
            .assertIsDisplayed()
    }


    @Test
    fun saveNote_returnsToNotesScreen() {

        composeTestRule
            .onNodeWithTag("AddNoteButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("TitleTextField")
            .performTextInput("Espresso Note")

        composeTestRule
            .onNodeWithTag("ContentTextField")
            .performTextInput("This is a test note")

        composeTestRule
            .onNodeWithTag("SaveNoteButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Your Notes")
            .assertIsDisplayed()
    }



}
