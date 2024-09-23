package com.devinci.appnotes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devinci.appnotes.dao.NoteDao
import com.devinci.appnotes.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}