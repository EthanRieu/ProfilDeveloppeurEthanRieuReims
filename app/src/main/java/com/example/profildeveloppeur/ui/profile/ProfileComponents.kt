package com.example.profildeveloppeur.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

/** En-tête de la fiche : nom et rôle du développeur. */
@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = role,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

/** Titre d'une section de la fiche (ex : « Compétences »). */
@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier
    )
}

/** Une compétence affichée dans une petite pastille colorée. */
@Composable
fun SkillItem(
    skill: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondaryContainer,
        shape = MaterialTheme.shapes.small
    ) {
        // Padding INTERNE : espace entre le bord de la pastille et le texte
        Text(
            text = skill,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

/** Information secondaire sous la forme « libellé : valeur » (contact, localisation…). */
@Composable
fun InfoLine(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "$label : $value",
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

/**
 * Zone cliquable PERSONNALISÉE indiquant la disponibilité.
 * Le composant signale seulement le clic via [onClick] : c'est le parent qui décide quoi faire.
 */
@Composable
fun AvailabilityBadge(
    isAvailable: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val label = if (isAvailable) {
        "Disponible pour une alternance"
    } else {
        "Non disponible actuellement"
    }

    Surface(
        // Chaîne de modifiers : on part du modifier du parent, puis
        // largeur -> clic -> sémantique pour les lecteurs d'écran
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .semantics {
                role = Role.Button
                contentDescription = "$label. Appuyer pour en savoir plus."
            },
        color = if (isAvailable) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.errorContainer
        },
        shape = MaterialTheme.shapes.medium
    ) {
        // Padding INTERNE : espace autour du texte à l'intérieur du badge
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(12.dp)
        )
    }
}

/** Bouton d'action principal. Le clic est remonté au parent via [onClick]. */
@Composable
fun ContactButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}
