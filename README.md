# **📱 Application de Prise de Note 📱**

Ce projet a été réalisé par **Auriane DUPIN, Clara-Belle GININES & Maxence VAYRE** - **A5 Fintech**

## **📋 Description**
Cette application Android vous permet de **prendre, afficher, modifier et supprimer des notes**. Elle est développée en Kotlin avec des composants modernes d'Android. 

### **🔑 Fonctionnalités** 



- **Afficher toutes les notes** 🗒️ : sous forme de liste.
- **Ajouter une nouvelle note** ➕ : interface simple pour créer une note.
- **Modifier une note existante** ✏️ : mettre à jour une note facilement.
- **Supprimer une note** 🗑️ : effacer les notes dont vous n'avez plus besoin.

### **🎥 Démo de l'application**

<video width="320" height="240" controls>
  <source src="https://github.com/user-attachments/assets/8f0f8d25-48a9-48c6-9a55-da91ba57d32e/video.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>

---

## **🏗️ Architecture**
L'application suit l'architecture **MVVM (Model-View-ViewModel)**.

### **Composants :**
- **RecyclerView** : pour afficher les notes sous forme de liste.
- **Room Database** : pour gérer les données en local.
- **ViewModel et LiveData** : pour observer et gérer les données en temps réel.

---

## **💻 Interfaces**
- **Page d'accueil** 🏠 : affiche toutes les notes avec un bouton flottant pour ajouter une nouvelle note.
- **Page d'ajout de note** 🆕 : permet d'ajouter une note dans la base de données.
- **Page de modification de note** ✍️ : modifiez une note existante.

---

## **🚀 Installation**

1. Clonez le dépôt :  
   ```bash
   git clone <url_du_dépôt>

2. Ouvrez le projet dans Android Studio.

3. Ajoutez les dépendances nécessaires dans le fichier build.gradle.kts :

// Room Database
implementation("androidx.room:room-runtime:2.6.1")
kapt("androidx.room:room-compiler:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")

// Lifecycle Components
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
kapt("androidx.lifecycle:lifecycle-compiler:2.7.0")

// Fragment KTX
implementation("androidx.fragment:fragment-ktx:1.6.2")

