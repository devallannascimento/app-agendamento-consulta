package com.devallannascimento.appagendaconsulta.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
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

        binding.btnRegistrar.setOnClickListener {

            val email = binding.editEmail.text.toString()

            validadorEmail(email)

            val handler = Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                Log.i("info_debug", "Activity Home Cumutada")
                finish()
            }, 0)
        }

        binding.textRecuperar.setOnClickListener {

            val handler = Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, SenhaActivity::class.java)
                startActivity(intent)
                Log.i("info_debug", "Activity Recuperar Senha Cumutada")
            }, 0)

        }

        binding.textRegistro.setOnClickListener {
            val handler = Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, RegistroActivity::class.java)
                startActivity(intent)
                Log.i("info_debug", "Activity Recuperar Senha Cumutada")
            }, 0)
        }

    }

    private fun validadorEmail(email: String) {

        fun validarEmail(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        if (email.isNotEmpty() && validarEmail(email)) {
            binding.TextInputLayoutEmail.isErrorEnabled = false
        } else {
            binding.TextInputLayoutEmail.isErrorEnabled = true
            binding.TextInputLayoutEmail.error = getString(R.string.email_invalido)
            Toast.makeText(this, "E-mail invalído", Toast.LENGTH_SHORT).show()
        }

    }

}