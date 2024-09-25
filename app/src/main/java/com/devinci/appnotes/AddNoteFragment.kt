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

<<<<<<< HEAD
// AddNoteFragment is a Fragment that allows the user to add a new note.
class AddNoteFragment : Fragment() {

=======
// AddNoteFragment est un fragment qui permet à l'utilisateur d'ajouter une nouvelle note.
class AddNoteFragment : Fragment() {

    // Méthode appelée pour créer la vue du fragment -> permet d'instancier la mise en page pour ce fragment.
>>>>>>> main
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
<<<<<<< HEAD
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_note_fragment, container, false)
    }

    // onViewCreated is called when the view is created. It sets up the click listeners for the buttons.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton: FloatingActionButton = view.findViewById(R.id.closingButton)
        closeButton.setOnClickListener {
=======
        // Instancie le layout associé à ce fragment
        return inflater.inflate(R.layout.add_note_fragment, container, false)
    }

    // onViewCreated est appelée lorsque la vue est créée -> permet de configurer les clics pour les boutons.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuration du FloatingActionButton
        val closeButton: FloatingActionButton = view.findViewById(R.id.closingButton)
        closeButton.setOnClickListener {
            // Ferme le fragment et revient à la pile précédente
>>>>>>> main
            parentFragmentManager.popBackStack()
        }

        val addButton: Button = view.findViewById(R.id.AddButton)
        addButton.setOnClickListener {
<<<<<<< HEAD
=======
            // Récupère les entrées de titre et de contenu
>>>>>>> main
            val titleInput: TextInputEditText = view.findViewById(R.id.textInputEditText)
            val contentInput: TextInputEditText = view.findViewById(R.id.textInputEditText2)
            val title = titleInput.text.toString()
            val content = contentInput.text.toString()

<<<<<<< HEAD
            if (title.isNotEmpty() && content.isNotEmpty()) {
=======
            // Vérifie si le titre et le contenu ne sont pas vides
            if (title.isNotEmpty() && content.isNotEmpty()) {
                // Crée un nouvel objet Note et l'insère via MainActivity
>>>>>>> main
                val note = Note(
                    title = title,
                    content = content
                )
                (activity as MainActivity).insertNote(note)
<<<<<<< HEAD
=======
                // Ferme le fragment après l'ajout de la note
>>>>>>> main
                parentFragmentManager.popBackStack()
            }
        }
    }
}