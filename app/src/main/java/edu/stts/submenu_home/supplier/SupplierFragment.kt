package edu.stts.submenu_home.supplier


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

import edu.stts.apotek_kotlin.R
import edu.stts.submenu_home.supplier.insert.DetailSupplierFragment
import edu.stts.ui.HomePresenter
import org.jetbrains.anko.find


class SupplierFragment : Fragment() {

    private lateinit var homePresenter: HomePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_supplier, container, false)

        homePresenter = HomePresenter()

        (view.find<FloatingActionButton>(R.id.fab)).setOnClickListener {
            homePresenter.changeFragment(fragmentManager!!,
                DetailSupplierFragment(),R.id.frame_main)
        }

        return view
    }


}
