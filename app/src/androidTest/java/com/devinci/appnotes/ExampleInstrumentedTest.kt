package com.devinci.appnotes

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
<<<<<<< HEAD
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
=======
 * Test instrumenté, qui sera exécuté sur un appareil Android.
 *
 * Voir la documentation des tests : [documentation des tests Android](http://d.android.com/tools/testing).
>>>>>>> main
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
<<<<<<< HEAD
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
=======
        // Récupère le contexte de l'application en cours de test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        // Vérifie que le nom du package est bien celui attendu.
>>>>>>> main
        assertEquals("com.devinci.appnotes", appContext.packageName)
    }
}