package edu.stts.submenu_home.kemasan


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import edu.stts.apotek_kotlin.R
import edu.stts.submenu_home.kemasan.detail.DetailKemasanFragment
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_kemasan.*


class KemasanFragment : Fragment() {

    private lateinit var  presenter: HomePresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kemasan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = HomePresenter()
        fab.setOnClickListener {
            presenter.changeFragment(fragmentManager!!,DetailKemasanFragment(),R.id.frame_main)
        }

    }


}
