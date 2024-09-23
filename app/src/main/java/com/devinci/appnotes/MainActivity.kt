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

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteRecycler: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var database: NoteDatabase
    private val notesArray: ArrayList<Note> = ArrayList()

    // onCreate method is called when the activity is created and is responsible for setting up the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the database
        database = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java, "note_database"
        ).build()

        // Set up the floating action button to open the AddNoteFragment
        binding.fab.setOnClickListener {
            openAddNoteFragment()
        }

        // Set up the RecyclerView to display the notes
        noteRecycler = findViewById(R.id.note_recycler)
        noteAdapter = NoteAdapter(notesArray, { note ->
            openEditNoteFragment(note)
        }, { note ->
            deleteNote(note)
        })
        noteRecycler.adapter = noteAdapter
        noteRecycler.layoutManager = GridLayoutManager(this, 2)

        loadNotes()
    }

    // Load the notes from the database
    private fun loadNotes() {
        CoroutineScope(Dispatchers.IO).launch {
            val notesList = database.noteDao().getAllNotes()
            runOnUiThread {
                noteAdapter.loadNotes(notesList.toMutableList())
            }
        }
    }

    // Insert a note into the database
    fun insertNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            database.noteDao().insert(note)
            loadNotes()
        }
    }

    // Update a note in the database
    fun updateNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            database.noteDao().update(note)
            loadNotes()
        }
    }

    // Delete a note from the database
    fun deleteNote(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            database.noteDao().delete(note)
            loadNotes()
        }
    }

    // Open the AddNoteFragment to add a new note
    private fun openAddNoteFragment() {
        val fragment: Fragment = AddNoteFragment()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    // Open the EditNoteFragment to edit an existing note
    private fun openEditNoteFragment(note: Note) {
        val fragment = EditNoteFragment.newInstance(note)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}