package edu.stts.submenu_home.supplier


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.stts.adapter.AdapterRecyclerSupplier

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.submenu_home.supplier.insert.DetailSupplierFragment
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_supplier.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.toast


class SupplierFragment : Fragment(), SupplierView{

    override fun showMessage(data: String) {
        toast(data)
    }

    override fun getDataSupplier(dataItems: List<ResultItem?>?) {
        if (dataItems != null){
            dataSupplier?.addAll(dataItems)
            adapterRecyclerSupplier = AdapterRecyclerSupplier(context,dataSupplier){}
            recycler_list.layoutManager = LinearLayoutManager(context)
            recycler_list.adapter = adapterRecyclerSupplier
            adapterRecyclerSupplier.notifyDataSetChanged()
        }
    }

    private lateinit var homePresenter: HomePresenter
    private lateinit var presenter: SupplierPresenter

    private lateinit var adapterRecyclerSupplier: AdapterRecyclerSupplier
    private var dataSupplier:ArrayList<ResultItem?>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_supplier, container, false)

        homePresenter = HomePresenter()
        presenter = SupplierPresenter(context!!,APIResponse().response(),this)

        (view.find<FloatingActionButton>(R.id.fab)).setOnClickListener {
            homePresenter.changeFragment(fragmentManager!!,
                DetailSupplierFragment(),R.id.frame_main)
        }

        dataSupplier = arrayListOf()
        adapterRecyclerSupplier = AdapterRecyclerSupplier(context,dataSupplier){}

        presenter.getDataSupplier()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}
