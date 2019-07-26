package edu.stts.apotek_kotlin.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIResponse {

    val url = "http://192.168.0.22:3000/"
    fun response():APIClient{
        val client = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return client.create(APIClient::class.java)
    }

}