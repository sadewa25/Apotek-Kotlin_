package edu.stts.apotek_kotlin.model


import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null
)