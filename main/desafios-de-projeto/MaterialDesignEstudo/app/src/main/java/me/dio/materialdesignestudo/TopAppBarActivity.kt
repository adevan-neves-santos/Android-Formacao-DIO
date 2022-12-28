package me.dio.materialdesignestudo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.dio.materialdesignestudo.databinding.ActivityTextFieldsBinding
import me.dio.materialdesignestudo.databinding.ActivityTopAppBarBinding
import me.dio.materialdesignestudo.extensions.toast

class TopAppBarActivity : AppCompatActivity() {
    private val binding by lazy { ActivityTopAppBarBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.topAppBar.setNavigationOnClickListener {
            toast("Clicou no menu de navegação")
        }
        binding.topAppBar.setOnMenuItemClickListener {
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
        fun createIntent(context:Context) = Intent(context, TopAppBarActivity::class.java)
    }
}
