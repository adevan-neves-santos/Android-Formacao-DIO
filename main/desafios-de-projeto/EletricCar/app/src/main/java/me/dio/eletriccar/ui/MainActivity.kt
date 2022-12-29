package me.dio.eletriccar.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import me.dio.eletriccar.R
import me.dio.eletriccar.data.CarFactory
import me.dio.eletriccar.databinding.ActivityMainBinding
import me.dio.eletriccar.ui.adapter.CarAdapter
import me.dio.eletriccar.ui.adapter.TabsAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var btnCalcular:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupListeners()
        val navController = findNavController(R.id.nav_host_fragment)
        setupWithNavController(binding.bottomNavigation,navController)
    }

    private fun setupView(){
        btnCalcular = binding.fabCalcular
    }

    private fun setupListeners(){
        btnCalcular.setOnClickListener {
            startActivity(Intent(this,CalcularAutonomiaActivity::class.java))
        }
    }
}