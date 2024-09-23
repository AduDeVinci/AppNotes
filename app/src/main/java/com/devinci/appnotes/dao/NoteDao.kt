package com.devinci.appnotes.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.devinci.appnotes.model.Note

//DAO pour les notes avec les fonctions d'insertion, de suppression, de mise à jour et de récupération de toutes les notes
@Dao
interface NoteDao {
    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): List<Note>

    @Insert
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(note: Note)
}