package edu.stts.submenu_home.kemasan.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.submenu_home.kemasan.KemasanFragment
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_detail_kemasan.*
import org.jetbrains.anko.support.v4.toast


class DetailKemasanFragment : Fragment(),DetailKemasanView {

    override fun showMessage(message: Boolean?) {
        if (message == true){
            toast(context?.getString(R.string.success_insert)!!)
            homePresenter.changeFragment(fragmentManager!!,KemasanFragment(),R.id.frame_main)
        }else{
            toast(context?.getString(R.string.failed_insert)!!)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kemasan, container, false)
    }

    private lateinit var presenter: DetailKemasanPresenter
    private lateinit var homePresenter: HomePresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = DetailKemasanPresenter(context,APIResponse().response(),this)
        homePresenter = HomePresenter()

        kemasan_btn.setOnClickListener {
            presenter.insertKemasan(ResultItem(name = kemasan_nama.text.toString()))
        }

    }

}
