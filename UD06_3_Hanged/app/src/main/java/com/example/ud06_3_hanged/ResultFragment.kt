package com.example.ud06_3_hanged

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.ud06_3_hanged.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    var _binding: FragmentResultBinding? = null
    val binding get() = _binding!!
    val model: GameViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.textResult.text = model.resultMessage()
        binding.btnRestart.setOnClickListener{
            //Toast.makeText(activity, model.targetWord, Toast.LENGTH_LONG).show()
            model.restart()
            view.findNavController().navigate(R.id.action_resultFragment2_to_gameFragment2)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
