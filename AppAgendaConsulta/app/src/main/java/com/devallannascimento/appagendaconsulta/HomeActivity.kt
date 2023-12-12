package com.devallannascimento.appagendaconsulta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import com.devallannascimento.appagendaconsulta.databinding.ActivityHomeBinding
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

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.add(R.id.fragmentConteudo, AgendarFragment())

        fragmentManager.commit()

        val bottomNavigationView: BottomNavigationView = binding.navBar

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_agendar -> {
                    loadFragment(AgendarFragment())
                    true
                }
                R.id.menu_agendamentos -> {
                    // Lógica para o item 2
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