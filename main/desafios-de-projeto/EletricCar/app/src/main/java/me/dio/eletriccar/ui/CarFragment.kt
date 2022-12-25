package me.dio.eletriccar.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import me.dio.eletriccar.R
import me.dio.eletriccar.data.CarFactory
import me.dio.eletriccar.databinding.CarFragmentBinding
import me.dio.eletriccar.ui.adapter.CarAdapter

class CarFragment : Fragment() {

    lateinit var btnCalcular: FloatingActionButton
    lateinit var listaCarros: RecyclerView

    private var _binding: CarFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CarFragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupListeners()
        setupList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupView(){
        btnCalcular  = binding.fabCalcular
        listaCarros  = binding.rvListaCarros
    }

    private fun setupList(){
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            startActivity(Intent(context,CalcularAutonomiaActivity::class.java))
        }
    }
}