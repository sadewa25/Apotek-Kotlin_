package edu.stts.submenu_home.kemasan


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import edu.stts.adapter.AdapterRecyclerKemasan
import edu.stts.adapter.AdapterRecyclerSupplier

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.submenu_home.kemasan.detail.DetailKemasanFragment
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_kemasan.*
import kotlinx.android.synthetic.main.fragment_kemasan.fab
import kotlinx.android.synthetic.main.fragment_kemasan.recycler_list
import kotlinx.android.synthetic.main.fragment_supplier.*
import org.jetbrains.anko.support.v4.toast


class KemasanFragment : Fragment(),KemasanView {

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(data: String) {
        toast(data)
    }

    override fun getDataKemasan(dataItems: List<ResultItem?>?) {
        if (dataItems != null){
            dataKemasan?.addAll(dataItems)
            adapterRecyclerKemasan = AdapterRecyclerKemasan(context,dataKemasan){}
            recycler_list.layoutManager = LinearLayoutManager(context)
            recycler_list.adapter = adapterRecyclerKemasan
            adapterRecyclerKemasan.notifyDataSetChanged()
        }
    }

    private lateinit var  presenter: HomePresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kemasan, container, false)
    }

    private lateinit var presenterKemasan: KemasanPresenter
    private lateinit var adapterRecyclerKemasan: AdapterRecyclerKemasan
    private var dataKemasan:ArrayList<ResultItem?>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = HomePresenter()
        presenterKemasan = KemasanPresenter(context,APIResponse().response(),this)

        fab.setOnClickListener {
            presenter.changeFragment(fragmentManager!!,DetailKemasanFragment(),R.id.frame_main)
        }

        dataKemasan = arrayListOf()
        adapterRecyclerKemasan = AdapterRecyclerKemasan(context!!,dataKemasan ){}

        presenterKemasan.getDataKemasan()

    }


}
