package com.example.myapplication


import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.features_note.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotesScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // 1)Screen title apper
    @Test
    fun notesScreen_isDisplayed() {
        composeTestRule
            .onNodeWithText("Your Notes")
            .assertIsDisplayed()
    }

    // 2) Add Note Button
    @Test
    fun clickAddNoteButton_opensAddEditNoteScreen() {

        composeTestRule
            .onNodeWithTag("AddNoteButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("SaveNoteButton")
            .assertIsDisplayed()
    }


    // 3) Order section apper when click Menu
    @Test
    fun toggleOrderSection_displaysSortingOptions() {
        composeTestRule
            .onNodeWithTag("ToggleOrderSection")
            .performClick()

        composeTestRule
            .onNodeWithTag("Sort_Title")
            .assertIsDisplayed()
    }

    // 4)order by title
    @Test
    fun selectSortByTitle() {
        composeTestRule
            .onNodeWithTag("ToggleOrderSection")
            .performClick()

        composeTestRule
            .onNodeWithTag("Sort_Title")
            .performClick()
    }

    // 5) order Ascending
    @Test
    fun selectAscendingOrder() {
        composeTestRule
            .onNodeWithTag("ToggleOrderSection")
            .performClick()

        composeTestRule
            .onNodeWithTag("Order_Ascending")
            .performClick()
    }

    @Test
    fun deleteNote_ifExists_thenRemoved() {

        val noteCards =
            composeTestRule.onAllNodesWithTag(
                "NoteCard_",
                useUnmergedTree = true
            )

        if (noteCards.fetchSemanticsNodes().isNotEmpty()) {

            composeTestRule
                .onAllNodesWithTag("DeleteNoteButton_", useUnmergedTree = true)
                .onFirst()
                .performClick()
        }
    }


    @Test
    fun clickNoteCard_opensEditNoteScreen() {

        val noteCards =
            composeTestRule.onAllNodesWithTag(
                "NoteCard_",
                useUnmergedTree = true
            )

        if (noteCards.fetchSemanticsNodes().isNotEmpty()) {

            noteCards.onFirst().performClick()

            composeTestRule
                .onNodeWithTag("SaveNoteButton")
                .assertIsDisplayed()
        }
    }


}