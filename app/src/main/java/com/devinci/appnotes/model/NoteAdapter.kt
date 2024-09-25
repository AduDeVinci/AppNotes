package com.devinci.appnotes.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devinci.appnotes.databinding.NoteItemBinding

// Adtapter for the RecyclerView in MainActivity
class NoteAdapter(
    private val notes: MutableList<Note>,
    private val onEditClick: (Note) -> Unit,
    private val onDeleteClick: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int = notes.size

    // Load new notes into the RecyclerView
    fun loadNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

    // ViewHolder for the RecyclerView qui associe les données à la vue (id, title, content)
    inner class NoteViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.noteId.text = "${note.id}. "
            binding.noteTitle.text = note.title
            binding.noteContent.text = note.content
            binding.editButton.setOnClickListener {
                onEditClick(note)
            }
            binding.deleteButton.setOnClickListener {
                onDeleteClick(note)
            }
        }
    }
}