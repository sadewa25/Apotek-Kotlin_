package edu.stts.submenu_home.supplier.insert


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import edu.stts.adapter.AdapterBank
import edu.stts.adapter.AdapterKota

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.model.Data
import edu.stts.apotek_kotlin.model.ResultItem
import org.jetbrains.anko.find


class DetailSupplierFragment : Fragment(), DetailSupplierView{

    /*BANK*/
    override fun getDataBank(dataItemsBank: List<ResultItem>) {
        if (dataItemsBank!=null){
            dataBank?.addAll(dataItemsBank)
            adapterBank = AdapterBank(context!!,dataBank)
            (views.find<Spinner>(R.id.supplier_bank)).adapter = adapterBank
            adapterBank.notifyDataSetChanged()
        }
    }
    /**/
    /*KOTA*/
    override fun getDataKota(dataItemsKota: List<ResultItem>) {
        if (dataItemsKota!=null){
            dataKota?.addAll(dataItemsKota)
            adapter = AdapterKota(context!!,dataKota)
            (views.find<Spinner>(R.id.supplier_kota)).adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }
    /**/

    private lateinit var adapter:AdapterKota
    private var dataKota: ArrayList<ResultItem?>? = null
    private lateinit var views:View
    private lateinit var presenter: DetailSupplierPresenter
    private lateinit var adapterBank:AdapterBank
    private var dataBank: ArrayList<ResultItem?>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_insert_supplier, container, false)

        views = view
        /*KOTA*/
        dataKota = arrayListOf()
        adapter = AdapterKota(context!!,dataKota)
        (view.find<Spinner>(R.id.supplier_kota)).adapter = adapter
        /**/

        /*BANK*/
        dataBank = arrayListOf()
        adapterBank = AdapterBank(context!!,dataBank)
        (view.find<Spinner>(R.id.supplier_bank)).adapter = adapterBank
        /**/

        presenter = DetailSupplierPresenter(context!!,APIResponse().response(),this)
        presenter.getKota()
        presenter.getBank()


        return view
    }


}
