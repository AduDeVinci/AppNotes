package com.devinci.appnotes

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Test instrumenté, qui sera exécuté sur un appareil Android.
 *
 * Voir la documentation des tests : [documentation des tests Android](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Récupère le contexte de l'application en cours de test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        // Vérifie que le nom du package est bien celui attendu.
        assertEquals("com.devinci.appnotes", appContext.packageName)
    }
}