package com.devinci.appnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devinci.appnotes.databinding.FragmentEditNoteBinding
import com.devinci.appnotes.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

// Fragment pour modifier une note dans la base de données et mettre à jour la RecyclerView
class EditNoteFragment : Fragment() {

    private var _binding: FragmentEditNoteBinding? = null
    // Propriété pour accéder aux vues liées via ViewBinding
    private val binding get() = _binding!!
    private lateinit var note: Note

    // Crée et retourne la vue du fragment avec le layout lié
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Permet de définir le titre et le contenu de la note dans les champs EditText et de mettre à jour la note dans la base de données (ne modifie pas l'identifiant).
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton: FloatingActionButton = view.findViewById(R.id.closingButton)
        closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        note = arguments?.getParcelable("note")!!

        // Remplit les champs de texte avec le titre et le contenu de la note
        binding.noteTitle.setText(note.title)
        binding.noteContent.setText(note.content)

        // Mise à jour de la note lors du clic sur le bouton
        binding.button.setOnClickListener {
            note.title = binding.noteTitle.text.toString() // Met à jour le titre de la note
            note.content = binding.noteContent.text.toString() // Met à jour le contenu de la note
            (activity as MainActivity).updateNote(note) // Appelle la méthode pour mettre à jour la note
            parentFragmentManager.popBackStack() // Ferme le fragment après la mise à jour
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
            args.putParcelable("note", note) // Passe la note en argument pour modification
            fragment.arguments = args
            return fragment
        }
    }
}