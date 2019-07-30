package edu.stts.submenu_home.principal.detail

import android.content.Context
import edu.stts.apotek_kotlin.client.APIClient
import edu.stts.apotek_kotlin.model.ResponseJSON
import edu.stts.apotek_kotlin.model.ResultItem
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPrincipalPresenter
    (val context: Context?, val client: APIClient, val view: DetailPrincipalView){

    fun insertPrincipal(dataPrincipal: ResultItem){
        client.insertPrincipal(dataPrincipal).enqueue(object : Callback<ResponseJSON> {
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                context?.toast("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.showMessage(response.body()!!.success)
                }
            }

        })
    }

    fun insertBankPrincipal(dataPrincipal: ResultItem){
        client.insertPrincipalBank(dataPrincipal).enqueue(object : Callback<ResponseJSON> {
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                context?.toast("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.showMessage(response.body()!!.success)
                }
            }

        })
    }

    fun getBank(){
        client.getDataBank().enqueue(object : Callback<ResponseJSON>{
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                context?.toast("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.getDataBank(response.body()!!.data?.result as ArrayList<ResultItem>)
                }
            }

        })
    }

}