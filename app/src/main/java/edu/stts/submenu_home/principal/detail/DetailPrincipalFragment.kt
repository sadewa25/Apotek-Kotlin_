package edu.stts.submenu_home.principal.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.menu.masters.MastersFragment
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_detail_principal.*
import org.jetbrains.anko.support.v4.toast

class DetailPrincipalFragment : Fragment(),DetailPrincipalView {

    override fun showMessage(message: Boolean?) {
        if (message == true){
            toast(context?.getString(R.string.success_insert)!!)
            homePresenter.changeFragment(fragmentManager!!, MastersFragment(),R.id.frame_main)
        }else{
            toast(context?.getString(R.string.failed_insert)!!)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_principal, container, false)
    }

    private lateinit var presenter: DetailPrincipalPresenter
    private lateinit var homePresenter: HomePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = DetailPrincipalPresenter(context, APIResponse().response(),this)
        homePresenter = HomePresenter()

        principal_btn.setOnClickListener {
            presenter.insertPrincipal(ResultItem(name = principal_nama.text.toString()))
        }

    }


}
