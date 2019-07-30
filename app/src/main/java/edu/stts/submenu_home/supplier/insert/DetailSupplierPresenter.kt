package edu.stts.submenu_home.supplier.insert

import android.content.Context
import edu.stts.apotek_kotlin.client.APIClient
import edu.stts.apotek_kotlin.model.ResponseJSON
import edu.stts.apotek_kotlin.model.ResultItem
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSupplierPresenter(val context: Context, val client:APIClient, val view: DetailSupplierView) {

    fun getKota(){
        client.getDataKota().enqueue(object : Callback<ResponseJSON>{
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                context?.toast("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.getDataKota(response.body()!!.data?.result as ArrayList<ResultItem>)
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

    fun insertSupplier(data:ResultItem){
        client.insertSupplier(data).enqueue(object : Callback<ResponseJSON>{
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                context?.toast("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.showToast(response.body()!!.success)
                }
            }

        })
    }

    fun getDataPrincipal(){
        client.getDataPrincipal().enqueue(object : Callback<ResponseJSON>{
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                context?.toast("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.getDataPrincipal(response.body()!!.data?.result as ArrayList<ResultItem>)
                }
            }
        })
    }

    fun getDataRekening(){
        client.getDataBank().enqueue(object : Callback<ResponseJSON>{
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                context?.toast("Error Koneksi : ${t.message}")
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                if (response.body() != null){
                    view.getDataRekening(response.body()!!.data?.result as ArrayList<ResultItem>)
                }
            }
        })
    }


}