package edu.stts.apotek_kotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Supplier(
    @PrimaryKey
    @ColumnInfo(name = "id_supplier") val idSupplier: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "npwp") val npwp: String,
    @ColumnInfo(name = "id_city") val idCity: String,
    @ColumnInfo(name = "postal_code") val postalCode: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "no_rekening") val noRekening: String,
    @ColumnInfo(name = "id_bank") val idBank: String
)