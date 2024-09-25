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
    // Récupère toutes les notes stockées dans la table "notes_table"
    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): List<Note>

    // Insère une nouvelle note dans la table
    @Insert
    fun insert(note: Note)

    // Supprime une note spécifique de la table
    @Delete
    fun delete(note: Note)

    // Met à jour une note existante dans la table
    @Update
    fun update(note: Note)
}