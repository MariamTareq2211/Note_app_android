package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.features_note.data.data_source.NoteDatabase
import com.example.myapplication.features_note.data.repository.NoteRepoImpl
import com.example.myapplication.features_note.domain.repository.NoteRepo
import com.example.myapplication.features_note.domain.use_case.NoteUseCases
import com.example.myapplication.features_note.domain.use_case.addNote
import com.example.myapplication.features_note.domain.use_case.deleteNote
import com.example.myapplication.features_note.domain.use_case.getNote
import com.example.myapplication.features_note.domain.use_case.getNotes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepo {
        return NoteRepoImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepo): NoteUseCases {
        return NoteUseCases(
            getNotes = getNotes(repository),
            deleteNote = deleteNote(repository),
            addNote = addNote(repository),
            getNote = getNote(repository)
        )
    }


}