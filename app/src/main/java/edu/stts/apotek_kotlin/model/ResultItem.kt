package edu.stts.apotek_kotlin.model

import com.google.gson.annotations.SerializedName

data class ResultItem(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("id_city")
	val idCity: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("npwp")
	val npwp: String? = null,

	@field:SerializedName("no_rekening")
	val noRekening: String? = null,

	@field:SerializedName("id_bank")
	val idBank: String? = null,

	@field:SerializedName("postal_code")
	val postalCode: String? = null,

	@field:SerializedName("id_supplier")
	val idSupplier: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)