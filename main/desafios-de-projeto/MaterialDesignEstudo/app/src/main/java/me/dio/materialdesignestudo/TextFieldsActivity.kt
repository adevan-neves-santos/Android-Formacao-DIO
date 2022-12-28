package me.dio.materialdesignestudo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.dio.materialdesignestudo.databinding.ActivityButtonsBinding
import me.dio.materialdesignestudo.databinding.ActivityTextFieldsBinding

class TextFieldsActivity : AppCompatActivity(){
    private val binding by lazy { ActivityTextFieldsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    companion object{
        fun createIntent(context: Context): Intent = Intent(context, TextFieldsActivity::class.java)
    }
}
