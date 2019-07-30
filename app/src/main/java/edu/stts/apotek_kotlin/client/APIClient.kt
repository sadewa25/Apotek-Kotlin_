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

    @POST("banksupplier/insert")
    fun insertBankSupplier(@Body body: ResultItem):Call<ResponseJSON>

    @POST("supplierprincipal/insert")
    fun insertPrincipalSupplier(@Body body: ResultItem):Call<ResponseJSON>

    @GET("category")
    fun getDataCategory():Call<ResponseJSON>

    @GET("lokosirak")
    fun getDataLokasiRak():Call<ResponseJSON>

    @POST("category/insert")
    fun insertProductCategory(@Body body: ResultItem):Call<ResponseJSON>

    @POST("supplier/insert")
    fun insertSupplier(@Body body: ResultItem):Call<ResponseJSON>

    @POST("kemasan/insert")
    fun insertKemasan(@Body body: ResultItem):Call<ResponseJSON>

    @GET("kemasan")
    fun getDataKemasan():Call<ResponseJSON>

    @POST("principal/insert")
    fun insertPrincipal(@Body body: ResultItem):Call<ResponseJSON>

    @POST("bankprincipal/insert")
    fun insertPrincipalBank(@Body body: ResultItem):Call<ResponseJSON>

    @GET("principal")
    fun getDataPrincipal():Call<ResponseJSON>


}