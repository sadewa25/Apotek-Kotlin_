package edu.stts.submenu_home.supplier.insert


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import edu.stts.adapter.AdapterBank
import edu.stts.adapter.AdapterKota

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.menu.masters.MastersFragment
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_insert_supplier.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.toast

class DetailSupplierFragment : Fragment(), DetailSupplierView{

    override fun getDataPrincipal(dataItemsPrincipal: List<ResultItem>) {
        dataPrincipal!!.addAll(dataItemsPrincipal)
        adapterPrincipal.notifyDataSetChanged()
    }

    override fun showToast(message: Boolean?) {
        if (message == true){
            toast(context?.getString(R.string.success_insert)!!)
            homePresenter.changeFragment(fragmentManager!!,MastersFragment(),R.id.frame_main)
        }else{
            toast(context?.getString(R.string.failed_insert)!!)
        }
    }

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
    private lateinit var homePresenter: HomePresenter
    private lateinit var adapterBank:AdapterBank
    private var dataBank: ArrayList<ResultItem?>? = null

    private var dataPrincipal:ArrayList<ResultItem?>? = null
    private lateinit var adapterPrincipal:AdapterBank

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_insert_supplier, container, false)

        views = view

        homePresenter = HomePresenter()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        supplier_btn.setOnClickListener {
            val modelKota = supplier_kota.selectedItem as ResultItem
            val modelBank = supplier_bank.selectedItem as ResultItem
            presenter.insertSupplier(ResultItem(
                name = supplier_nama.text.toString(),
                address = supplier_alamat.text.toString(),
                phone = supplier_phone.text.toString(),
                npwp = supplier_npwp.text.toString(),
                idCity = modelKota.idCity,
                postalCode = supplier_kodepos.text.toString(),
                email = supplier_email.text.toString(),
                idBank = modelBank.idBank

            ))
        }

        supplier_principal_btn.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            val mDialogView = LayoutInflater.from(context).inflate(R.layout.item_dialog_principal_bank, null)
            builder.setView(mDialogView)
            val dialog = builder.create()
            val spinner = mDialogView.find<Spinner>(R.id.dialog_bank)

            dataPrincipal = arrayListOf()
            adapterPrincipal = AdapterBank(context!!,dataPrincipal)
            spinner.adapter = adapterPrincipal
            presenter.getDataPrincipal()
            /*Menghilangkan EditText*/
            val noRekening = mDialogView.find<EditText>(R.id.dialog_rekening)
            noRekening.visibility = View.GONE
            val namaRekening = mDialogView.find<EditText>(R.id.dialog_namarekening)
            namaRekening.visibility = View.GONE
            /*END*/

            (mDialogView.find<Button>(R.id.btn_submit)).setOnClickListener {
                val modelBank = spinner.selectedItem as ResultItem

                dialog.dismiss()
            }
            dialog.show()

        }

    }


}
