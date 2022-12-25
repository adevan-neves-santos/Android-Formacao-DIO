package me.dio.eletriccar.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import me.dio.eletriccar.data.CarFactory
import me.dio.eletriccar.databinding.CarFragmentBinding
import me.dio.eletriccar.domain.Carro
import me.dio.eletriccar.ui.adapter.CarAdapter
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class CarFragment : Fragment() {

    lateinit var btnCalcular: FloatingActionButton
    lateinit var listaCarros: RecyclerView

    var carrosArray:ArrayList<Carro> = ArrayList()

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
        callService()
        setupView()
        setupListeners()
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
        val adapter = CarAdapter(carrosArray)
        listaCarros.adapter = adapter
    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            startActivity(Intent(context,CalcularAutonomiaActivity::class.java))
        }
    }

    private fun callService(){
        val urlBase = "https://igorbag.github.io/cars-api/cars.json"
        MyTask().execute(urlBase)
    }

    inner class MyTask:AsyncTask<String,String,String>(){

        override fun onPreExecute() {
            super.onPreExecute()
            Log.d("MyTask","Iniciando ...")
        }

        override fun doInBackground(vararg url: String?): String {
            var urlConnection: HttpURLConnection? = null
            try {
                val urlBase = URL(url[0])
                urlConnection = urlBase.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 60000
                urlConnection.readTimeout = 60000

                var response = urlConnection.inputStream.bufferedReader().use { it.readText() }
                publishProgress(response)
            } catch (ex:Exception){
                Log.e("Erro","Erro ao realizar processamento ...")
            } finally {
                urlConnection?.disconnect()
            }
            return " "
        }

        override fun onProgressUpdate(vararg values: String?) {
            try {
                val jsonArray = JSONTokener(values[0]).nextValue() as JSONArray
                for(i in 0 until jsonArray.length()){
                    val id = jsonArray.getJSONObject(i).getString("id")
                    Log.d("ID -->",id)

                    val preco = jsonArray.getJSONObject(i).getString("preco")
                    Log.d("Preço -->",preco)

                    val bateria = jsonArray.getJSONObject(i).getString("bateria")
                    Log.d("Bateria -->",bateria)

                    val potencia = jsonArray.getJSONObject(i).getString("potencia")
                    Log.d("Potência -->",potencia)

                    val recarga = jsonArray.getJSONObject(i).getString("recarga")
                    Log.d("Recarga -->",recarga)

                    val urlPhoto = jsonArray.getJSONObject(i).getString("urlPhoto")
                    Log.d("UrlPhoto -->",urlPhoto)

                    val model =  Carro(
                         id       = id.toInt()
                        ,preco    = preco
                        ,bateria  = bateria
                        ,potencia = potencia
                        ,recarga  = recarga
                        ,urlPhoto = urlPhoto
                    )
                    carrosArray.add(model)
                    Log.d("Model -> ",model.toString())
                }
                setupList()
            } catch (ex:Exception){
                Log.e("Erro",ex.message.toString())
            }
        }
    }

}