package edu.stts.apotek_kotlin.client

import edu.stts.apotek_kotlin.model.BodyRequestRetrofit
import edu.stts.apotek_kotlin.model.ResponseJSON
import edu.stts.apotek_kotlin.model.ResultItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIClient {

    @GET("kota")
    fun getDataKota():Call<ResponseJSON>

    @GET("bank")
    fun getDataBank():Call<ResponseJSON>

    @GET("supplier")
    fun getDataSupplier():Call<ResponseJSON>

    @POST("category/insert")
    fun insertProductCategory(@Body body: ResultItem):Call<ResponseJSON>

    @POST("supplier/insert")
    fun insertSupplier(@Body body: ResultItem):Call<ResponseJSON>

}