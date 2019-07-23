package edu.stts.apotek_kotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class DataClassModel {

    @Entity
    data class Principal(
        @PrimaryKey val idPrincipal: String?,
        @ColumnInfo(name = "namaPrincinpal") val namaPrincipal: String?
    )

    @Entity
    data class Category(
        @PrimaryKey val idKategori: String?,
        @ColumnInfo(name = "namaKategori") val namaKategori: String?
    )


    @Entity
    data class Kemasan(
        @PrimaryKey val idKemasan: String?,
        @ColumnInfo(name = "namaKemasan") val namaKemasan: String?
    )

    @Entity
    data class LokasiRak(
        @PrimaryKey val idLokasi: String?,
        @ColumnInfo(name = "namaLokasi") val namaKemasan: String?
    )

    @Entity
    data class Produk(
        @PrimaryKey val idProduk: String?,
        @ColumnInfo(name = "idPrincipal") val idPrincipal: String?,
        @ColumnInfo(name = "idCategory") val idCategory: String?,
        @ColumnInfo(name = "nama_produk") val namaProduk: String?,
        @ColumnInfo(name = "HNA") val hna: String?,
        @ColumnInfo(name = "HJA") val hja: String?,
        @ColumnInfo(name = "hargaBeli") val hargaBeli: String?,
        @ColumnInfo(name = "idKemasan") val idKemasan: String?,
        @ColumnInfo(name = "berat") val berat: String?,
        @ColumnInfo(name = "lokasi/rak") val lokasi: String?
    )

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

    @Entity
    data class City(
        @PrimaryKey
        @ColumnInfo(name = "id_city") val idCity: String,
        @ColumnInfo(name = "name") val name: String
    )

    @Entity
    data class Bank(
        @PrimaryKey
        @ColumnInfo(name = "id_bank") val idBank: String,
        @ColumnInfo(name = "name") val name: String
    )

}