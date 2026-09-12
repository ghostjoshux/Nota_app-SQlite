package com.example.nota_app_sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nota_app_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: NotasDatabaseHelper
    private lateinit var notasAdaptador: NotasAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotasDatabaseHelper(this)

        notasAdaptador = NotasAdaptador(db.getAllNotas(), this)

        binding.notasRv.layoutManager = LinearLayoutManager(this)

        binding.notasRv.adapter = notasAdaptador

        binding.fabAgregarNota.setOnClickListener {
            Toast.makeText(this, "Has presionado en el FAB", Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext, AgregarNotaActivityBinding::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        notasAdaptador.refrescarLista(db.getAllNotas())
    }
}
