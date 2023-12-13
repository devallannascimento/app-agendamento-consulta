package com.devallannascimento.appagendaconsulta.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devallannascimento.appagendaconsulta.R
import com.devallannascimento.appagendaconsulta.databinding.ActivityHomeBinding
import com.devallannascimento.appagendaconsulta.fragments.AgendamentosFragment
import com.devallannascimento.appagendaconsulta.fragments.AgendarFragment
import com.devallannascimento.appagendaconsulta.fragments.PerfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = binding.navBar

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_agendar -> {
                    loadFragment(AgendarFragment())
                    true
                }
                R.id.menu_agendamentos -> {
                    loadFragment(AgendamentosFragment())
                    true
                }
                R.id.menu_perfil -> {
                    loadFragment(PerfilFragment())
                    true
                }
                else -> false
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentConteudo, fragment)
            .commit()
    }

}