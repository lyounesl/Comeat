package com.example.comeat

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saisieEmail: TextView = findViewById(R.id.email)
        val saisieMdp: TextView = findViewById(R.id.mdp)

        val boutonConnecter: Button = findViewById(R.id.connecter)

        boutonConnecter.setOnClickListener {
            val email: String = saisieEmail.text.toString()
            val mdp: String = saisieMdp.text.toString()

            Log.d("ACT_CONN", "Connexion : $email/$mdp")
        }

        val boutonAnnuler: Button = findViewById(R.id.annuler)

        boutonAnnuler.setOnClickListener {
            saisieEmail.text = ""
            saisieMdp.text = ""

            Log.d("ACT_CONN", "Annulation")
        }
    }
}