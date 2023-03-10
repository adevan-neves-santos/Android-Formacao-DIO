package me.dio.navigationestudo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.dio.navigationestudo.R
import me.dio.navigationestudo.databinding.FragmentPersonalDataBinding
import me.dio.navigationestudo.model.PersonModel
import me.dio.navigationestudo.extensions.text

class PersonalDataFragment : Fragment() {
    private var _binding:FragmentPersonalDataBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentPersonalDataBinding.inflate(inflater,group,false)
        return binding.root
    }

    override fun onViewCreated(view: View, saved: Bundle?) {
        super.onViewCreated(view, saved)
        binding.btnNext.setOnClickListener {
            val model = PersonModel(
                name = binding.tilName.text,
                age = binding.tilAge.text.toInt()
            )
            // TODO : Aviso, o fragment que irá receber o argumento deve ter declarado em nav_graph a TAG argument
            // eu confundi com a tela anterior a ele e nãoe estava aceitando
            val directions = PersonalDataFragmentDirections.goToAdressDataFragment(model)
            findNavController().navigate(directions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}