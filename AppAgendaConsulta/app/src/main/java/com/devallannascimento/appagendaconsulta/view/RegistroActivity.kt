package com.devallannascimento.appagendaconsulta.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.devallannascimento.appagendaconsulta.R
import com.devallannascimento.appagendaconsulta.databinding.ActivityMainBinding
import com.devallannascimento.appagendaconsulta.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRegistroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textFacaLogin.setOnClickListener {
            val handler = Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                Log.i("info_debug", "Activity Home Cumutada")
                finish()
            }, 0)
        }

        binding.textVoltar.setOnClickListener {
            finish()
        }

        binding.btnRegistrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val nome = binding.editNome.text.toString()
            val sobrenome = binding.editSobrenome.text.toString()

            validadorNome(nome)
            validadorNome(sobrenome)
            validadorEmail(email)

            recuperarDados()

            finish()
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

    private fun recuperarDados() {
        try {
            val cpf = binding.editCpf.text.toString()

            // Remover caracteres não numéricos, exceto zeros à esquerda
            val cpfNumerico = cpf.replace("\\D".toRegex(), "")

            // Verificar se a string não está vazia
            if (cpfNumerico.isNotEmpty()) {

                Log.i("info_projeto", "recuperarDado: $cpfNumerico ")
            } else {
                Log.i("info_projeto", "recuperarDado: CPF vazio")
            }
        } catch (e: NumberFormatException) {
            Log.i("info_projeto", "recuperarDado: ERRO [$e] ")
        }
    }

    private fun validadorNome(nome: String) {

        fun validarNome(nome: String): Boolean {
            // Utiliza uma expressão regular para permitir apenas letras com ou sem acento
            val regex = Regex("[^a-zA-ZÀ-ÖØ-öø-ÿ]")
            return !regex.containsMatchIn(nome)
        }

        if (nome.isNotEmpty() && validarNome(nome)) {
            binding.TextInputLayoutNome.isErrorEnabled = false
        } else {
            binding.TextInputLayoutNome.isErrorEnabled = true
            binding.TextInputLayoutNome.error = getString(R.string.nome_invalido)
            Toast.makeText(this, "Nome invalído", Toast.LENGTH_SHORT).show()
        }

    }

}