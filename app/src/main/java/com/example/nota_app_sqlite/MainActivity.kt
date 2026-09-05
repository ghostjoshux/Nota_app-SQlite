package com.example.nota_app_sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nota_app_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAgregarNota.setOnClickListener {
            Toast.makeText(this, "Has presionado en el FAB", Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext, AgregarNotaActivity::class.java))
        }
    }
}
