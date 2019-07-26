package edu.stts.submenu_home.supplier

import android.content.Context
import edu.stts.apotek_kotlin.client.APIClient
import edu.stts.apotek_kotlin.model.ResponseJSON
import edu.stts.apotek_kotlin.model.ResultItem
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SupplierPresenter(val context: Context, val client:APIClient, val view: SupplierView) {

    fun getDataSupplier(){
        client.getDataSupplier().enqueue(object : Callback<ResponseJSON> {
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                view.showMessage("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.getDataSupplier(response.body()!!.data?.result as ArrayList<ResultItem>)
                }
            }

        })
    }

}