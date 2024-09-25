**Application de Prise de Note**


**Description**

Cette application Android est conçue pour permettre aux utilisateurs de prendre, afficher, modifier et supprimer des notes. Elle est construite en Kotlin, utilisant les composants modernes d'architecture Android.

Fonctionnalités :

  - Afficher toutes les notes.
  - Ajouter une nouvelle note.
  - Modifier une note existante.
  - Supprimer une note.
  - Architecture


L'application suit l'architecture MVVM (Model-View-ViewModel) et utilise les composants suivants :

RecyclerView : Pour l'affichage des notes.
Room Database : Pour la gestion locale des données.
ViewModel et LiveData : Pour gérer et observer les données.
Interfaces
Page d'accueil : Affiche toutes les notes avec un bouton flottant pour ajouter une nouvelle note.
Page d'ajout de note : Permet d'ajouter une nouvelle note dans la base de données.
Page de mise à jour : Permet de modifier une note existante.

**Installation**

Cloner ce repository :
bash
Copier le code
git clone 
Ouvrir le projet dans Android Studio.
Assurez-vous d'avoir ajouté les dépendances nécessaires dans le fichier build.gradle.kts :
kotlin

**Room Database**
implementation("androidx.room:room-runtime:2.6.1")
kapt("androidx.room:room-compiler:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")

**Lifecycle components**
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
kapt("androidx.lifecycle:lifecycle-compiler:2.7.0")

**Fragment KTX**
implementation("androidx.fragment:fragment-ktx:1.6.2")
Synchronisez le projet avec Gradle.

Lancer l'application sur un émulateur ou un appareil physique.
Configuration techniques nécessaire :

  - Kotlin 1.7+
  - Android SDK 21+  
  - Android Studio Bumblebee ou version supérieure
