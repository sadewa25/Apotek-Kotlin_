package edu.stts.submenu_home.lokasirak

import android.content.Context
import edu.stts.apotek_kotlin.client.APIClient
import edu.stts.apotek_kotlin.model.ResponseJSON
import edu.stts.apotek_kotlin.model.ResultItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LokasiRakFragmentPresenter(
    val context: Context, val client: APIClient, val view: LokasiRakFragmentView
) {
    fun getDataLokasiRak(){
        client.getDataCategory().enqueue(object : Callback<ResponseJSON> {
            override fun onFailure(call: Call<ResponseJSON>, t: Throwable) {
                view.showToast(t.message.toString())
            }

            override fun onResponse(call: Call<ResponseJSON>, response: Response<ResponseJSON>) {
                view.showToast(response.body()?.message.toString())
                view.showDataLokasiRak(response.body()?.data?.result as List<ResultItem>)
            }
        })
    }
}