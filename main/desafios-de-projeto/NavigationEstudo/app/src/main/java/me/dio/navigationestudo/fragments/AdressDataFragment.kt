package me.dio.navigationestudo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.dio.navigationestudo.databinding.FragmentAdressBinding
import me.dio.navigationestudo.model.PersonModel
import me.dio.navigationestudo.extensions.text

class AdressDataFragment  : Fragment(){
    private var _binding: FragmentAdressBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentAdressBinding.inflate(inflater,group,false)
        return binding.root
    }

    override fun onViewCreated(view: View, saved: Bundle?) {
        super.onViewCreated(view, saved)
        binding.btnNext.setOnClickListener {
            val model = PersonModel(
                name = "",
                age = 0,
                street = binding.tilStreet.text,
                number = binding.tilNumber.text.toInt()
            )
            // TODO mandar os dados para o outro fragment

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}