package edu.stts.submenu_home.supplier.insert

import android.content.Context
import edu.stts.apotek_kotlin.client.APIClient
import edu.stts.apotek_kotlin.model.Data
import edu.stts.apotek_kotlin.model.ResponseJSON
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSupplierPresenter(val context: Context, val client:APIClient, val view: DetailSupplierView) {

    fun getKota(){
        client.getDataKota().enqueue(object : Callback<ResponseJSON>{
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                context?.toast("Error Koneksi")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.getDataKota(response.body()!!.data as ArrayList<Data>)
                }
            }

        })
    }

}