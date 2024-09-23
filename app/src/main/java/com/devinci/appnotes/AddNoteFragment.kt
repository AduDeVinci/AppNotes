package com.devinci.appnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.devinci.appnotes.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

// AddNoteFragment is a Fragment that allows the user to add a new note.
class AddNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_note_fragment, container, false)
    }

    // onViewCreated is called when the view is created. It sets up the click listeners for the buttons.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton: FloatingActionButton = view.findViewById(R.id.closingButton)
        closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val addButton: Button = view.findViewById(R.id.AddButton)
        addButton.setOnClickListener {
            val titleInput: TextInputEditText = view.findViewById(R.id.textInputEditText)
            val contentInput: TextInputEditText = view.findViewById(R.id.textInputEditText2)
            val title = titleInput.text.toString()
            val content = contentInput.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                val note = Note(
                    title = title,
                    content = content
                )
                (activity as MainActivity).insertNote(note)
                parentFragmentManager.popBackStack()
            }
        }
    }
}