package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_start, container, false)
        val btnStart = view.findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener{
            view.findNavController().navigate(R.id.action_startFragment_to_chooseFragment)
        }
        return view
    }
}