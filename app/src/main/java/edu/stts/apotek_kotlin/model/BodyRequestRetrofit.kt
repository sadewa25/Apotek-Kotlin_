package edu.stts.apotek_kotlin.model

data class BodyRequestRetrofit(
    val success:String,
    val message:String,
    val data:ArrayList<Data>
)