package com.example.ud05_1_justit

import android.os.Bundle
import android.service.controls.actions.FloatAction
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ud05_1_justit.databinding.ActivityMainBinding
import com.example.ud05_1_justit.databinding.FragmentOrderBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {

    var _binding: FragmentOrderBinding? = null
    val binding: FragmentOrderBinding
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        //=  inflater.inflate(R.layout.fragment_order, container, false)
        val view = binding.root
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity) .setSupportActionBar(toolbar)

        var fabSend = view.findViewById<FloatingActionButton>(R.id.fabSend)
        fabSend.setOnClickListener{
            val burguerGroup = view.findViewById<RadioGroup>(R.id.group_burguer_type)
            val burguerType = burguerGroup.checkedRadioButtonId
            if (burguerType == -1){
                Toast.makeText(activity, R.string.alert_select_type, Toast.LENGTH_SHORT).show()
            }else{
                var msn = R.string.burguer_selected
                msn += when(burguerType){
                    R.id.radio_american -> R.string.american
                    R.id.radio_vegan -> R.string.vegan
                    R.id.radio_chicken -> R.string.chicken
                    else -> "Error"
                }
                Snackbar.make(fabSend, msn, Snackbar.LENGTH_SHORT).show()
                
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}