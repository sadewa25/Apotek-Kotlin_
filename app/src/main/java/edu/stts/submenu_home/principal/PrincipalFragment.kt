package edu.stts.submenu_home.principal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import edu.stts.apotek_kotlin.R
import edu.stts.submenu_home.principal.detail.DetailPrincipalFragment
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_principal.*

class PrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    private lateinit var homePresenter: HomePresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter = HomePresenter()
        fab.setOnClickListener {
            homePresenter.changeFragment(fragmentManager!!,DetailPrincipalFragment(),R.id.frame_main)
        }
    }

}
