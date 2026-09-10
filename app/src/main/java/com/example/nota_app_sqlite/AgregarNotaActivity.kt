package com.example.nota_app_sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.nota_app_sqlite.databinding.ActivityAgregarNotaBinding

class AgregarNotaActivityBinding : AppCompatActivity() {


    private lateinit var binding: ActivityAgregarNotaBinding
    private lateinit var db: NotasDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotasDatabaseHelper(this)

        binding.GuardarNota.setOnClickListener {
            val titulo = binding.etTitulo.text.toString()
            val descripcion = binding.etDescripcion.text.toString()
            if (titulo.isNotEmpty() && descripcion.isNotEmpty()) {
                guardarNota(titulo, descripcion)
            } else {
                Toast.makeText(applicationContext, "LLENE LOS CAMPOS", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun guardarNota(titulo: String, descripcion: String) {
        val nota = Nota(0, titulo, descripcion)
        db.insertNota(nota)
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finishAffinity()
        Toast.makeText(applicationContext, "Se ha agregado la nota", Toast.LENGTH_SHORT).show()
    }
}
