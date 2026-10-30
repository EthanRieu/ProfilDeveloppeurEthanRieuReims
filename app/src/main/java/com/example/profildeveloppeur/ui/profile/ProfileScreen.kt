package com.example.profildeveloppeur.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.model.DeveloperProfile
import com.example.profildeveloppeur.model.androidJuniorProfile
import com.example.profildeveloppeur.model.fullstackProfile
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

/** Écran principal : structure de la page (Scaffold) qui place la fiche profil. */
@Composable
fun ProfileScreen(
    profile: DeveloperProfile,
    onContactClick: () -> Unit,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        ProfileCard(
            profile = profile,
            onContactClick = onContactClick,
            onAvailabilityClick = onAvailabilityClick,
            // Padding EXTERNE : décidé par le parent pour placer la carte dans l'écran
            // (innerPadding évite les barres système, 16.dp écarte la carte des bords)
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        )
    }
}

/** Fiche profil complète, assemblée à partir des petits composables réutilisables. */
@Composable
fun ProfileCard(
    profile: DeveloperProfile,
    onContactClick: () -> Unit,
    onAvailabilityClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = MaterialTheme.shapes.large
    ) {
        // Padding INTERNE : espace entre le bord de la carte et son contenu
        Column(modifier = Modifier.padding(20.dp)) {
            ProfileHeader(name = profile.name, role = profile.role)

            Text(
                text = profile.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 12.dp)
            )

            SectionTitle(
                title = "Compétences",
                modifier = Modifier.padding(top = 16.dp)
            )
            // Pas de LazyColumn (non vue en cours) : une simple boucle sur la liste suffit
            profile.skills.forEach { skill ->
                SkillItem(
                    skill = skill,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }

            SectionTitle(
                title = "Informations",
                modifier = Modifier.padding(top = 16.dp)
            )
            InfoLine(
                label = "Contact",
                value = profile.contact,
                modifier = Modifier.padding(top = 6.dp)
            )
            InfoLine(
                label = "Localisation",
                value = profile.location,
                modifier = Modifier.padding(top = 4.dp)
            )

            AvailabilityBadge(
                isAvailable = profile.isAvailable,
                onClick = onAvailabilityClick,
                modifier = Modifier.padding(top = 16.dp)
            )

            ContactButton(
                text = "Contacter ${profile.name}",
                onClick = onContactClick,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}

@Preview(name = "Profil Android junior (disponible)", showBackground = true)
@Composable
fun ProfileScreenAndroidJuniorPreview() {
    ProfilDeveloppeurTheme(dynamicColor = false) {
        ProfileScreen(
            profile = androidJuniorProfile,
            onContactClick = {},
            onAvailabilityClick = {}
        )
    }
}

@Preview(name = "Profil full-stack (non disponible)", showBackground = true)
@Composable
fun ProfileScreenFullstackPreview() {
    ProfilDeveloppeurTheme(dynamicColor = false) {
        ProfileScreen(
            profile = fullstackProfile,
            onContactClick = {},
            onAvailabilityClick = {}
        )
    }
}
