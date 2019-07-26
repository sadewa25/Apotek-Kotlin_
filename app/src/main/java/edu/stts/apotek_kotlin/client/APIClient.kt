package edu.stts.apotek_kotlin.client

import edu.stts.apotek_kotlin.model.ResponseJSON
import retrofit2.Call
import retrofit2.http.GET

interface APIClient {

    @GET("kota")
    fun getDataKota():Call<ResponseJSON>

}