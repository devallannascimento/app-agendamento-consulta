package com.devallannascimento.appagendaconsulta.fragments

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devallannascimento.appagendaconsulta.R
import com.devallannascimento.appagendaconsulta.databinding.FragmentPerfilBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSalvar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val nome = binding.editNome.text.toString()
            val sobrenome = binding.editSobrenome.text.toString()

            validadorNome(nome)
            validadorNome(sobrenome)
            validadorEmail(email)
            recuperarDados()

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
            Toast.makeText(requireContext(), "E-mail invalído", Toast.LENGTH_SHORT).show()
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
            Toast.makeText(requireContext(), "Nome invalído", Toast.LENGTH_SHORT).show()
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PerfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PerfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}