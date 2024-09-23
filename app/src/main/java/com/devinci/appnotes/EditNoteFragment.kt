package com.devinci.appnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devinci.appnotes.databinding.FragmentEditNoteBinding
import com.devinci.appnotes.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

// Fragment for editing a note in the database and updating the RecyclerView
class EditNoteFragment : Fragment() {

    private var _binding: FragmentEditNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var note: Note

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Set the note title and content to the EditText fields and update the note in the database (doesn't change the id)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton: FloatingActionButton = view.findViewById(R.id.closingButton)
        closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        note = arguments?.getParcelable("note")!!

        binding.noteTitle.setText(note.title)
        binding.noteContent.setText(note.content)

        binding.button.setOnClickListener {
            note.title = binding.noteTitle.text.toString()
            note.content = binding.noteContent.text.toString()
            (activity as MainActivity).updateNote(note)
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Companion object to create a new instance of the fragment with a note argument (the one to be edited)
    companion object {
        fun newInstance(note: Note): EditNoteFragment {
            val fragment = EditNoteFragment()
            val args = Bundle()
            args.putParcelable("note", note)
            fragment.arguments = args
            return fragment
        }
    }
}