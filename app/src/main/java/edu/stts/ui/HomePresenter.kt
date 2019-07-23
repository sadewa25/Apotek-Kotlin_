package edu.stts.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class HomePresenter {

    fun changeFragment(manager:FragmentManager,fragment: Fragment,id:Int){
        val transaksi = manager.beginTransaction()
        transaksi.replace(id,fragment).addToBackStack(null).commit()
    }

}