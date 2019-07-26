package edu.stts.apotek_kotlin.model

import com.google.gson.annotations.SerializedName

data class ResponseJSON(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: Any? = null
)