package com.example.enlacedeactividades

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.enlacedeactividades.databinding.Acividad2Binding
import com.example.enlacedeactividades.databinding.ActivityMainBinding

class Actividad2 : AppCompatActivity() {
    lateinit var binding:Acividad2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Acividad2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnClose.setOnClickListener {
            this.finish()
        }
        val p= Person("Cardoso")
        Toast.makeText(this, "Persona: " + p.toString(), Toast.LENGTH_SHORT).show()
    }
}