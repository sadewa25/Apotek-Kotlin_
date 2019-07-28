package edu.stts.submenu_home.principal.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import edu.stts.adapter.AdapterBank

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.menu.masters.MastersFragment
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_detail_principal.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.toast

class DetailPrincipalFragment : Fragment(),DetailPrincipalView {

    override fun getDataBank(dataItemsBank: List<ResultItem>) {
        if (dataItemsBank!=null){
            dataBank?.addAll(dataItemsBank)
            dataBank?.addAll(dataItemsBank)
            adapterBank = AdapterBank(context!!,dataBank)
            adapterBank.notifyDataSetChanged()
        }
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

    private var dataBank:ArrayList<ResultItem?>? = null
    private lateinit var adapterBank: AdapterBank
    private lateinit var mDialogView:View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = DetailPrincipalPresenter(context, APIResponse().response(),this)
        homePresenter = HomePresenter()

        dataRekening = arrayListOf()
        dataBank = arrayListOf()

        adapterBank = AdapterBank(context!!,dataBank)

        principal_btn.setOnClickListener {
            presenter.insertPrincipal(ResultItem(
                name = principal_nama.text.toString(),
                address = principal_address.text.toString(),
                phone = principal_phone.text.toString() ))
        }

        principal_btn_rekening.setOnClickListener {
            val dialog = AlertDialog.Builder(context!!)
            mDialogView = LayoutInflater.from(context).inflate(R.layout.item_dialog_principal_bank, null)
            dialog.setView(mDialogView)

            presenter.getBank()

            val spinner = mDialogView.find<Spinner>(R.id.dialog_bank)
            spinner.adapter = adapterBank

            dialog.show()
        }


    }


}
