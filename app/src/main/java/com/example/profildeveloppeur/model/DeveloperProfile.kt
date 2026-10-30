package com.example.profildeveloppeur.model

/**
 * Données affichées par la fiche profil.
 * Les composables reçoivent ces valeurs en paramètres : ils ne contiennent aucune donnée en dur.
 */
data class DeveloperProfile(
    val name: String,
    val role: String,
    val description: String,
    val skills: List<String>,
    val contact: String,
    val location: String,
    val isAvailable: Boolean
)

// Profil principal (utilisé dans l'application et la première preview)
val androidJuniorProfile = DeveloperProfile(
    name = "Ethan Rieu",
    role = "Développeur Android junior",
    description = "Étudiant en Master 1 à l'ESGI Reims, passionné par le développement mobile. " +
        "J'apprends Jetpack Compose et je recherche une alternance en développement Android.",
    skills = listOf("Kotlin", "Jetpack Compose", "Git / GitHub", "SQL"),
    contact = "ethan.rieu@exemple.com",
    location = "Reims, France",
    isAvailable = true
)

// Profil fictif pour montrer une deuxième variante (non disponible, autres compétences)
val fullstackProfile = DeveloperProfile(
    name = "Camille Martin",
    role = "Développeuse full-stack",
    description = "Développeuse full-stack avec 4 ans d'expérience sur des applications web et mobiles.",
    skills = listOf("TypeScript", "React", "Node.js", "PostgreSQL", "Docker"),
    contact = "camille.martin@exemple.com",
    location = "Paris, France",
    isAvailable = false
)
