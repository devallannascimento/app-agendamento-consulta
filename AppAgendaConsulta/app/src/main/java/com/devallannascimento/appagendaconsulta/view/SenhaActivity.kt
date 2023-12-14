package com.devallannascimento.appagendaconsulta.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.devallannascimento.appagendaconsulta.R
import com.devallannascimento.appagendaconsulta.databinding.ActivitySenhaBinding

class SenhaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySenhaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textVoltar.setOnClickListener {
            finish()
        }

        binding.btnRecuperar.setOnClickListener {
            finish()
        }

        binding.textRegistrar.setOnClickListener {
            val handler = Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, RegistroActivity::class.java)
                startActivity(intent)
                Log.i("info_debug", "Activity Registro Cumutada")
                finish()
            }, 0)
        }

    }
}