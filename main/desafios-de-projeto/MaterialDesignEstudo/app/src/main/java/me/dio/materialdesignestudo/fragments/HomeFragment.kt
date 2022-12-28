package me.dio.materialdesignestudo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.dio.materialdesignestudo.R

class HomeFragment  : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, group,false)
    }
    companion object{
        fun newInstance() = HomeFragment()
    }
}