package me.dio.materialdesignestudo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import me.dio.materialdesignestudo.databinding.ActivityButtonsBinding

class ButtonsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityButtonsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    companion object{
        fun createIntent(context: Context):Intent = Intent(context, ButtonsActivity::class.java)
    }
}
