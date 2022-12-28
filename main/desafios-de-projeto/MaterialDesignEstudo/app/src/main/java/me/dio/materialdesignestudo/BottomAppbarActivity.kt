package me.dio.materialdesignestudo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.dio.materialdesignestudo.databinding.ActivityBottomAppBarBinding
import me.dio.materialdesignestudo.extensions.toast

class BottomAppbarActivity : AppCompatActivity(){
    private val binding by lazy { ActivityBottomAppBarBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.bottomAppBar.setNavigationOnClickListener {
            toast("Clicou no menu de navegação")
        }
        binding.bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId){
                R.id.edit -> {
                    toast("Edit")
                    true
                }
                R.id.favorite -> {
                    toast("Favorite")
                    true
                }
                R.id.more   -> {
                    toast("More")
                    true
                }
                else -> false
            }
        }
    }
    companion object{
        fun createIntent(context: Context) = Intent(context, BottomAppbarActivity::class.java)
    }
}
