package edu.stts.submenu_home.principal.detail

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
import edu.stts.adapter.AdapterRekening

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.menu.masters.MastersFragment
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_detail_principal.*
import kotlinx.android.synthetic.main.fragment_insert_supplier.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.toast
import java.util.*
import kotlin.collections.ArrayList

class DetailPrincipalFragment : Fragment(),DetailPrincipalView {

    override fun getDataBank(dataItemsBank: List<ResultItem>){
        dataBank!!.addAll(dataItemsBank)
        adapterBank.notifyDataSetChanged()
    }

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

    private var dataRekening:ArrayList<ResultItem?>? = null
    private lateinit var adapterRekening: AdapterRekening

    private var dataBank:MutableList<ResultItem?>? = null
    private lateinit var adapterBank: AdapterBank
    private lateinit var mDialogView:View

    fun getID():String{
        return "${Calendar.getInstance()
            .getTimeInMillis()}"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = DetailPrincipalPresenter(context, APIResponse().response(),this)
        homePresenter = HomePresenter()

        dataRekening = arrayListOf()
        dataBank = mutableListOf()

        adapterRekening = AdapterRekening(context!!,dataRekening)
        principal_list_rekening.adapter = adapterRekening
        principal_list_rekening.isNestedScrollingEnabled = true

        principal_btn.setOnClickListener {
            val idPrincipal = getID()
            presenter.insertPrincipal(ResultItem(
                id_principal = "${idPrincipal}",
                name = principal_nama.text.toString(),
                address = principal_address.text.toString(),
                phone = principal_phone.text.toString()))

            for(i in 0 until dataRekening!!.size){
                presenter.insertBankPrincipal(
                    ResultItem(
                        id_principal = idPrincipal,
                        idBank = dataRekening?.get(i)?.idBank,
                        noRekening = dataRekening?.get(i)?.noRekening,
                        pemilik_rekening = dataRekening?.get(i)?.pemilik_rekening
                    )
                )
            }
        }

        principal_btn_rekening.setOnClickListener {
            val builder = AlertDialog.Builder(context!!)
            mDialogView = LayoutInflater.from(context).inflate(R.layout.item_dialog_principal_bank, null)
            builder.setView(mDialogView)
            val dialog = builder.create()
            val spinner = mDialogView.find<Spinner>(R.id.dialog_bank)

            adapterBank = AdapterBank(context!!,dataBank)
            spinner.adapter = adapterBank
            presenter.getBank()

            val noRekening = mDialogView.find<EditText>(R.id.dialog_rekening)
            val namaRekening = mDialogView.find<EditText>(R.id.dialog_namarekening)

            (mDialogView.find<Button>(R.id.btn_submit)).setOnClickListener {
                val modelBank = spinner.selectedItem as ResultItem

                dataRekening!!.add(ResultItem(
                    idBank = modelBank.idBank,
                    noRekening = noRekening.text.toString(),
                    pemilik_rekening = namaRekening.text.toString()
                ))
                adapterRekening.notifyDataSetChanged()

                dialog.dismiss()
            }
            dialog.show()

        }

    }

}
