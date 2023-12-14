package com.devallannascimento.appagendaconsulta.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.devallannascimento.appagendaconsulta.R
import com.devallannascimento.appagendaconsulta.databinding.FragmentAgendarBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgendarFragment : Fragment() {

    private var _binding: FragmentAgendarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAgendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupere o array de especialidades do arquivo de recursos
        val especialidades = resources.getStringArray(R.array.especialidades_array)

        // Crie um adaptador usando um layout personalizado para os itens do spinner
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, especialidades)

        // Especifique o layout a ser usado quando a lista aparecer
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Aplique o adaptador ao spinner usando View Binding
        binding.spinnerEspecialidades.adapter = adapter

        // Adicione um ouvinte de seleção ao Spinner
        binding.spinnerEspecialidades.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()

                // Verifique se a categoria selecionada não é "Selecione uma categoria"
                if (selectedItem != "Selecione uma categoria") {
                    Toast.makeText(requireContext(), "Categoria selecionada: $selectedItem", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Lógica a ser executada quando nenhum item é selecionado
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AgendarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}