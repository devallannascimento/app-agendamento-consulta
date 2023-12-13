package com.devallannascimento.appagendaconsulta.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.devallannascimento.appagendaconsulta.R
import com.devallannascimento.appagendaconsulta.databinding.ActivityHomeBinding
import com.devallannascimento.appagendaconsulta.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val handler = Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Log.i("info_debug", "Activity Home Cumutada")
                finish()
            }, 0)
        }
    }
}