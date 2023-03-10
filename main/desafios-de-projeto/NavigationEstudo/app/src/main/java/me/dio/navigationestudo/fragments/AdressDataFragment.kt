package me.dio.navigationestudo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import me.dio.navigationestudo.databinding.FragmentAdressBinding
import me.dio.navigationestudo.model.PersonModel
import me.dio.navigationestudo.extensions.text

class AdressDataFragment  : Fragment(){
    private var _binding: FragmentAdressBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<AdressDataFragmentArgs>()
    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentAdressBinding.inflate(inflater,group,false)
        return binding.root
    }

    override fun onViewCreated(view: View, saved: Bundle?) {
        super.onViewCreated(view, saved)
        Log.e("Model",args.model.toString())
        binding.btnNext.setOnClickListener {
            val model = args.model.copy(
                street = binding.tilStreet.text,
                number = binding.tilNumber.text.toInt()
            )

            val directions = AdressDataFragmentDirections.goToResumeFragment(model)
            findNavController().navigate(directions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}