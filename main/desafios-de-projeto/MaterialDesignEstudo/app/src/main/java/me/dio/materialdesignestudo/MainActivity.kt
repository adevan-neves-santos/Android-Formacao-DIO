package me.dio.materialdesignestudo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.dio.materialdesignestudo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        insertListerners()
    }

    private fun insertListerners() {
        binding.cdButtons.setOnClickListener {
            startActivity(ButtonsActivity.createIntent(this))
        }
        binding.cdTextFields.setOnClickListener {
            startActivity(TextFieldsActivity.createIntent(this))
        }
        binding.cdBottomSheets.setOnClickListener {
            ModalBottomSheet.start(supportFragmentManager)
        }
        binding.cdTopAppBar.setOnClickListener {
            startActivity(TopAppBarActivity.createIntent(this))
        }
        binding.cdBottomAppBar.setOnClickListener {
            startActivity(BottomAppbarActivity.createIntent(this))
        }
        binding.cdSnackbars.setOnClickListener {
            startActivity(SnackbarActivity.createIntent(this))
        }
        binding.cdBottomNavigation.setOnClickListener {
            startActivity(BottomNavigationActivity.createIntent(this))
        }
    }
}