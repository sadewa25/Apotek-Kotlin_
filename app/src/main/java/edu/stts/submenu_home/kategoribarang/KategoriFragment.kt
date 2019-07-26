package edu.stts.submenu_home.kategoribarang


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

import edu.stts.apotek_kotlin.R
import edu.stts.submenu_home.kategoribarang.insert.DetailKategoriFragment
import edu.stts.ui.HomePresenter
import org.jetbrains.anko.find


class KategoriFragment : Fragment(){
    private lateinit var homePresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kategori, container, false)
        homePresenter = HomePresenter()
        (view.find<FloatingActionButton>(R.id.fab)).setOnClickListener {
            homePresenter.changeFragment(fragmentManager!!,
                DetailKategoriFragment(),R.id.frame_main)
        }
        return view
    }
}
