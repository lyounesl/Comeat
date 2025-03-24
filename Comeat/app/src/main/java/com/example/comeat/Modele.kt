package com.example.comeat

// Assurez-vous d'avoir cette classe définie quelque part
data class Utilisateur(
    val id: Int,
    val nom: String,
    val prenom: String,
    val email: String,
    val mdp: String // En pratique, stockez plutôt un hash du mot de passe
)

object Modele {
    private val utilisateurs: MutableList<Utilisateur> = mutableListOf(
        Utilisateur(1, "LOTHBROK", "RAGNAR", "ragnar.lothbrok@gmail.com", "Odin@Thor"),
        Utilisateur(2, "LOTHBROK", "Lagertha", "lagertha.lothbrok@gmail.com", "Loki&Freyja")
    )

    fun findUtilisateur(email: String, mdp: String): Utilisateur? {
        // Solution 1: Boucle explicite (comme vous aviez)
        for (utilisateur in utilisateurs) {
            if (utilisateur.email.equals(email, ignoreCase = true) && utilisateur.mdp == mdp) {
                return utilisateur
            }
        }
        return null

        // Solution 2: Version plus concise avec find()
        // return utilisateurs.find { it.email.equals(email, ignoreCase = true) && it.mdp == mdp }
    }

    // Ajout possible: fonction pour ajouter un utilisateur
    fun addUtilisateur(utilisateur: Utilisateur) {
        utilisateurs.add(utilisateur)
    }
}