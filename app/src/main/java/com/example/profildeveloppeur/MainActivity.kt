package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.profildeveloppeur.model.androidJuniorProfile
import com.example.profildeveloppeur.ui.profile.ProfileScreen
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurTheme {
                ProfileScreen(
                    profile = androidJuniorProfile,
                    onContactClick = {
                        // Plus tard : ouvrir l'application mail pour contacter le développeur
                    },
                    onAvailabilityClick = {
                        // Plus tard : afficher le détail de la disponibilité
                    }
                )
            }
        }
    }
}
