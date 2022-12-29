package me.dio.navigationestudo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import me.dio.navigationestudo.databinding.FragmentAdressBinding
import me.dio.navigationestudo.databinding.FragmentResumeBinding
import me.dio.navigationestudo.extensions.text
import me.dio.navigationestudo.model.PersonModel

class ResumeFragment : Fragment(){
    private var _binding: FragmentResumeBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<ResumeFragmentArgs>()
    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentResumeBinding.inflate(inflater,group,false)
        return binding.root
    }

    override fun onViewCreated(view: View, saved: Bundle?) {
        super.onViewCreated(view, saved)
        binding.tvPerson.text = args.model.person
        binding.tvAdress.text = args.model.adress
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}