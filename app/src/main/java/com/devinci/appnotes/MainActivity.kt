package com.devinci.appnotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.devinci.appnotes.databinding.ActivityMainBinding
import com.devinci.appnotes.db.NoteDatabase
import com.devinci.appnotes.model.Note
import com.devinci.appnotes.model.NoteAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // Propriété pour accéder à la vue liée via ViewBinding
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteRecycler: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var database: NoteDatabase
    private val notesArray: ArrayList<Note> = ArrayList()

    // La méthode onCreate est appelée lors de la création de l'activité et est responsable de sa configuration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Création de la base de données
        database = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java, "note_database"
        ).build()

        // Configuration du bouton flottant pour ouvrir le fragment AddNoteFragment
        binding.fab.setOnClickListener {
            openAddNoteFragment()
        }

        // Configuration du RecyclerView pour afficher les notes
        noteRecycler = findViewById(R.id.note_recycler)
        noteAdapter = NoteAdapter(notesArray, { note ->
            openEditNoteFragment(note) // Ouvre le fragment d'édition lors du clic sur une note
        }, { note ->
            deleteNote(note) // Supprime la note lors du clic sur le bouton de suppression
        })
        noteRecycler.adapter = noteAdapter
        noteRecycler.layoutManager = GridLayoutManager(this, 2)
        // Chargement des notes depuis la base de données
        loadNotes()
    }

    // Charge les notes depuis la base de données et les affiche dans le RecyclerView
    private fun loadNotes() {
        CoroutineScope(Dispatchers.IO).launch {
            val notesList = database.noteDao().getAllNotes()
            runOnUiThread {
                noteAdapter.loadNotes(notesList.toMutableList())
            }
        }
    }

    // Insère une nouvelle note dans la base de données
    fun insertNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            database.noteDao().insert(note)
            loadNotes() // Recharge les notes après insertion
        }
    }

    // Met à jour une note existante dans la base de données
    fun updateNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            database.noteDao().update(note)
            loadNotes() // Recharge les notes après la mise à jour
        }
    }

    // Supprime une note de la base de données
    fun deleteNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            database.noteDao().delete(note)
            loadNotes() // Recharge les notes après suppression
        }
    }

    // Ouvre le fragment AddNoteFragment pour ajouter une nouvelle note
    private fun openAddNoteFragment() {
        val fragment: Fragment = AddNoteFragment()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null) // Ajoute le fragment à la pile pour permettre le retour en arrière
        transaction.commit()
    }

    // Ouvre le fragment EditNoteFragment pour modifier une note existante
    private fun openEditNoteFragment(note: Note) {
        val fragment = EditNoteFragment.newInstance(note)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}