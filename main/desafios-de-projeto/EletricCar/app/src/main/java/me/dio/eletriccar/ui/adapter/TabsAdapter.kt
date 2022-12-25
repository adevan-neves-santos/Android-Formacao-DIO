package me.dio.eletriccar.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.dio.eletriccar.ui.CarFragment
import me.dio.eletriccar.ui.FavoriteFragment

class TabsAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    //Devolve o fragment que queremos utilizar na tela
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CarFragment()
            1 -> FavoriteFragment()
            else -> CarFragment()
        }
    }
    //Quantidade de tabs itens de navegação
    override fun getItemCount() = 2

}