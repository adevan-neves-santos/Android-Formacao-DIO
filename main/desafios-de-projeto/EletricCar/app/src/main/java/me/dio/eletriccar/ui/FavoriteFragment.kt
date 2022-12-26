package me.dio.eletriccar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import me.dio.eletriccar.R
import me.dio.eletriccar.data.local.CarRepository
import me.dio.eletriccar.databinding.CarFragmentBinding
import me.dio.eletriccar.databinding.FavoriteFragmentBinding
import me.dio.eletriccar.domain.Carro
import me.dio.eletriccar.ui.adapter.CarAdapter

class FavoriteFragment  : Fragment() {

    lateinit var listaCarrosFavoritos : RecyclerView

    private var _binding: FavoriteFragmentBinding? = null
    private val binding get() = _binding!!
    lateinit var repository:CarRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FavoriteFragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        repository = CarRepository(requireContext())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupList()
    }

    override fun onResume() {
        super.onResume()
        setupList()
    }

    private fun getCarsOnLocalDb(): List<Carro> {
        val carList = repository.getAll()
        return carList
    }

    private fun setupView(view:View){
        view.apply {
            listaCarrosFavoritos = binding.rvListaCarrosFavoritos
        }
    }

    private fun setupList(){
        var cars:List<Carro> = getCarsOnLocalDb()
        val carroAdapter = CarAdapter(cars,isFavoriteScreen = true)
        listaCarrosFavoritos.apply {
            isVisible = true
            adapter = carroAdapter
        }
        carroAdapter.carItemLister = {carro ->
            repository.delete(carro.id)
        }

    }

}