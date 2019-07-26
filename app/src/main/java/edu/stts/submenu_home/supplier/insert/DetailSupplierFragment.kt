package edu.stts.submenu_home.supplier.insert


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import edu.stts.adapter.AdapterKota

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.model.Data
import edu.stts.apotek_kotlin.model.ResultItem
import org.jetbrains.anko.find


class DetailSupplierFragment : Fragment(), DetailSupplierView{

    override fun getDataKota(dataItemsKota: List<ResultItem>) {
        if (dataItemsKota!=null){
            dataKota?.addAll(dataItemsKota)
            adapter = AdapterKota(context!!,dataKota)
            (views.find<Spinner>(R.id.supplier_kota)).adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    private lateinit var adapter:AdapterKota
    private var dataKota: ArrayList<ResultItem?>? = null
    private lateinit var views:View
    private lateinit var presenter: DetailSupplierPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_insert_supplier, container, false)

        views = view
        dataKota = arrayListOf()
        adapter = AdapterKota(context!!,dataKota)
        (view.find<Spinner>(R.id.supplier_kota)).adapter = adapter

        presenter = DetailSupplierPresenter(context!!,APIResponse().response(),this)
        presenter.getKota()


        return view
    }


}
