package com.example.comeat

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RechercheRepasActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche_repas)

        // choix de la spécialité culinaire

        var libelleSpecialite: String = ""
        var dateRepas: String = ""

        val spnSpecialite: Spinner = findViewById(R.id.select_specialite)
        // val specialites = listof( "Provençal" , "Marocain" , "Libanais" , "Afghan" , "Coréen" )
        val specialites = Modele.getSpecialites()
        val adaptateur = ArrayAdapter(this, android.R.layout.simple_spinner_item, specialites)
        adaptateur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnSpecialite.adapter = adaptateur

        fun onItemSelected(
            parentView: AdapterView<*>,
            selectedItemView: View?,
            position: Int,
            id: Long
        ) {
        }

        fun onNothingSelected(parentView: AdapterView<*>) {
            //si aucun repas n'est selectionner

        }

        // sélection de la date
        val btnDate: Button = findViewById(R.id.select_date)
        val tvDate: TextView = findViewById(R.id.aff_date)
        btnDate.setOnClickListener {
            val dateCourante = LocalDate.now()
            val annee = dateCourante.year
            val mois = dateCourante.monthValue - 1
            val jour = dateCourante.dayOfMonth

            val datePickerDialog = DatePickerDialog(
                this,
                { view, anneeSelect, moisSelect, jourSelect ->
                    val dateSelectionnee = LocalDate.of(
                        anneeSelect,
                        moisSelect + 1,
                        jourSelect
                    )
                    val formateur = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val dateFormatee = dateSelectionnee.format(formateur)

                    tvDate.text = dateFormatee
                },
                annee, mois, jour
            )
            datePickerDialog.show()
        }

        //Validation et navigation
        val btnValider: Button = findViewById( R.id.valider )
        btnValider.setOnClickListener {
            val intent = Intent( this , ListeRepasActivity::class.java)
            intent.putExtra( "specialite_repas" , specialiteRepas )
            intent.putExtra( "date_repas" , dateRepas.toString() )
            startActivity( intent )
        }

    }
}