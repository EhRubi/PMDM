package com.example.ud06_3_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.ud06_3_hanged.GameViewModel
import com.example.ud06_3_hanged.R
import com.example.ud06_3_hanged.databinding.FragmentGameBinding
import com.google.android.material.snackbar.Snackbar


class GameFragment : Fragment() {
    var _binding: FragmentGameBinding? = null
    val binding get() = _binding!!

    val model: GameViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game, container, false)
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
//Inicializamos la palabra
        updateScreen()
        binding.btnNext.setOnClickListener {
            if (binding.secretWord.text.length > 0) {
                //Comprobar la letra introducida
                model.guess(binding.editTry.text.get(0))
                //Actualizamos la pantalla
                updateScreen()
                //Si acertamos la palabra o nos quedamos sin vidas
                if (model.win() || model.lost())  view.findNavController().navigate(R.id.action_gameFragment2_to_resultFragment2)
            } else {
                //Sino se introduce ningún texto mostramos un aviso
                Snackbar.make(view, "Introduce una letra", Snackbar.LENGTH_SHORT).show()
            }
            model.targetWordHidden.observe(
                viewLifecycleOwner,
                Observer {
                    binding.secretWord.text = model.targetWordHidden.value
                })
        }
        return view
    }
    fun updateScreen(){
//        binding.secretWord.text = model.targetWordHidden.value
        binding.lives.text = "Te quedan ${model.lives} vidas"
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}