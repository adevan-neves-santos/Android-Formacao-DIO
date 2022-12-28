package me.dio.materialdesignestudo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import me.dio.materialdesignestudo.databinding.ActivityBottomNavigationBinding
import me.dio.materialdesignestudo.fragments.HomeFragment
import me.dio.materialdesignestudo.fragments.StartsFragment

class BottomNavigationActivity : AppCompatActivity(){
    private val binding by lazy { ActivityBottomNavigationBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.home -> openFragment(HomeFragment.newInstance())
                R.id.star -> openFragment(StartsFragment.newInstance())
            }
            true
        }
        binding.bottomNavigation.selectedItemId = R.id.home
    }
    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()

    }
    companion object{
        fun createIntent(context: Context) : Intent = Intent(context,BottomNavigationActivity::class.java)
    }
}
