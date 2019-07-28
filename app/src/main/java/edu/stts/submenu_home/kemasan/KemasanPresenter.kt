package edu.stts.submenu_home.kemasan

import android.content.Context
import edu.stts.apotek_kotlin.client.APIClient
import edu.stts.apotek_kotlin.model.ResponseJSON
import edu.stts.apotek_kotlin.model.ResultItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KemasanPresenter(val context: Context?, val client:APIClient, val view: KemasanView) {

    fun getDataKemasan(){
        client.getDataKemasan().enqueue(object : Callback<ResponseJSON> {
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                view.showMessage("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.getDataKemasan(response.body()!!.data?.result as ArrayList<ResultItem>)
                }
            }

        })
    }

}