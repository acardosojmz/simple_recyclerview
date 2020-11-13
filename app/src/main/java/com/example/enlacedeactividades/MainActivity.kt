package com.example.enlacedeactividades

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.enlacedeactividades.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG=this.javaClass.name.toUpperCase()
    val CALL_REQUEST_CODE=1

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupPermissions()
        binding.btnOpen.setOnClickListener {

            val i = Intent(this, Actividad2::class.java )
            startActivity(i)
        }

        binding.btnCall.setOnClickListener {
            val i= Intent(Intent.ACTION_CALL,Uri.parse("tel:9513618396"))
            startActivity(i)
        }

    }
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permiso denegado ")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CALL_PHONE),
                CALL_REQUEST_CODE)
    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            CALL_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "El usuario no autorizo el permiso")
                } else {
                    Log.i(TAG, "Permiso autorizado por el usuario")
                }
            }
        }
    }
}