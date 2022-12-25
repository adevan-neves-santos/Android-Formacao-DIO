package me.dio.eletriccar.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import me.dio.eletriccar.data.CarFactory
import me.dio.eletriccar.databinding.ActivityMainBinding
import me.dio.eletriccar.ui.adapter.CarAdapter
import me.dio.eletriccar.ui.adapter.TabsAdapter


class MainActivity : AppCompatActivity() {

    lateinit var tabLayout:TabLayout
    lateinit var viewPager: ViewPager2

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupTabs()
    }

    private fun setupView() {
        tabLayout    = binding.tabLayout
        viewPager    = binding.vpViewPager
    }


    private fun setupTabs(){
        val tabsAdapter = TabsAdapter(this)
        viewPager.adapter = tabsAdapter
        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            //Momento em que é selecionada
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager.currentItem = it.position
                }
            }
            // Quando não é selecionada a tab
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            // Quando voltarmos a selecionar ela
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        viewPager.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.getTabAt(position)?.select()
            }
        })
    }
}