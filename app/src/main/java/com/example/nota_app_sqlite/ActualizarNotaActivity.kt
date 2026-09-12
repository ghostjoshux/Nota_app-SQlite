package com.example.nota_app_sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nota_app_sqlite.databinding.ActivityActualizarNotaBinding

class ActualizarNotaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActualizarNotaBinding
    private lateinit var db : NotasDatabaseHelper
    private var idNota: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActualizarNotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotasDatabaseHelper(this)

        idNota = intent.getIntExtra("id_nota", -1)
        if (idNota == -1) {
            finish()
            return
        }
        val nota = db.getIdNota(idNota)
        binding.etTitulo.setText(nota.titulo)
        binding.etDescripcion.setText(nota.descripcion)

        binding.btnActualizarNota.setOnClickListener {
            val tituloNuevo = binding.etTitulo.text.toString()
            val descripcionNuevo = binding.etDescripcion.text.toString()

            val notaActualizada = Nota(idNota, tituloNuevo, descripcionNuevo)
            db.updateNota(notaActualizada)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            Toast.makeText(this, "La nota se ha actualizado", Toast.LENGTH_SHORT).show()
        }
    }
}
