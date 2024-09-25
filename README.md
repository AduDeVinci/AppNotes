# **📝 Application de Prise de Note**

## **📋 Description**
Cette application Android vous permet de **prendre, afficher, modifier et supprimer des notes**. Elle est développée en Kotlin avec des composants modernes d'Android. 

### **🔑 Fonctionnalités** 



- **Afficher toutes les notes** 🗒️ : sous forme de liste.
- **Ajouter une nouvelle note** ➕ : interface simple pour créer une note.
- **Modifier une note existante** ✏️ : mettre à jour une note facilement.
- **Supprimer une note** 🗑️ : effacer les notes dont vous n'avez plus besoin.
<img width="319" alt="screen" src="https://github.com/user-attachments/assets/ff18effa-9374-47a9-aa16-df51736318f1">
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

Ouvrez le projet dans Android Studio.

Ajoutez les dépendances nécessaires dans le fichier build.gradle.kts :



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

Synchronisez le projet avec Gradle.

Lancez l'application sur un émulateur ou un appareil physique.

