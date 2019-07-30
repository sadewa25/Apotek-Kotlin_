package edu.stts.submenu_home.principal


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import edu.stts.adapter.AdapterRecyclerKemasan
import edu.stts.adapter.AdapterRecyclerPrincipal

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.submenu_home.kemasan.KemasanPresenter
import edu.stts.submenu_home.principal.detail.DetailPrincipalFragment
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_kemasan.*
import kotlinx.android.synthetic.main.fragment_principal.*
import kotlinx.android.synthetic.main.fragment_principal.fab
import kotlinx.android.synthetic.main.fragment_principal.recycler_list
import org.jetbrains.anko.support.v4.toast

class PrincipalFragment : Fragment(),PrincipalView{

    override fun showMessage(data: String) {
        toast(data)
    }

    override fun getDataPrincipal(dataItems: List<ResultItem?>?) {
        if (dataItems != null){
            dataPrincipal?.addAll(dataItems)
            adapterRecyclerPrincipal = AdapterRecyclerPrincipal(context,dataPrincipal){}
            recycler_list.layoutManager = LinearLayoutManager(context)
            recycler_list.adapter = adapterRecyclerPrincipal
            adapterRecyclerPrincipal.notifyDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    private lateinit var homePresenter: HomePresenter
    private lateinit var presenterPrincipal: PrincipalPresenter
    private lateinit var adapterRecyclerPrincipal: AdapterRecyclerPrincipal
    private var dataPrincipal:ArrayList<ResultItem?>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter = HomePresenter()
        fab.setOnClickListener {
            homePresenter.changeFragment(fragmentManager!!,DetailPrincipalFragment(),R.id.frame_main)
        }

        dataPrincipal = arrayListOf()
        adapterRecyclerPrincipal = AdapterRecyclerPrincipal(context!!,dataPrincipal ){}

        presenterPrincipal.getDataPrincipal()

    }

}
