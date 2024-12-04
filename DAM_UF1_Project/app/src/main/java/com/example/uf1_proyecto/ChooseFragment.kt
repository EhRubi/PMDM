package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class ChooseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choose, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.botton_navigation)

        // Cargar el fragmento inicial (StartFragment)
        if (savedInstanceState == null) {
            childFragmentManager.commit {
                replace(R.id.fragment_container, StartFragment())
            }
        }

        // Configurar la navegación entre fragmentos
        bottomNavigationView.setOnItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.startFragment -> StartFragment()
                R.id.chooseFragment -> ChooseFragment()
                R.id.helpFragment -> HelpFragment()
                else -> StartFragment() // Fragmento por defecto
            }
            childFragmentManager.commit {
                replace(R.id.fragment_container, selectedFragment)
            }
            true
        }
        // Manejo del botón de retroceso
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Verifica si hay fragmentos anteriores en el stack
                val fragmentManager = childFragmentManager
                if (fragmentManager.backStackEntryCount > 0) {
                    // Si hay fragmentos en el stack, retrocede uno
                    fragmentManager.popBackStack()
                } else {
                    // Si no hay fragmentos en el stack, realiza la acción por defecto (salir)
                    requireActivity().onBackPressed()
                }
            }
        })

        return view
    }
}