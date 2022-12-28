package me.dio.materialdesignestudo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import me.dio.materialdesignestudo.databinding.ActivitySnackbarBinding

class SnackbarActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySnackbarBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.showing.setOnClickListener {
            Snackbar.make(it,"Clique no primeiro botão",Snackbar.LENGTH_SHORT).show()
        }
        binding.action.setOnClickListener {
            Snackbar.make(it,"O segundo botão foi clicado",Snackbar.LENGTH_LONG).setAction("Go"){
                Log.e("TAG","onCreate: clicou na ação")
            }.show()
        }
    }

    companion object{
        fun createIntent(context: Context) = Intent(context,SnackbarActivity::class.java)
    }
}
