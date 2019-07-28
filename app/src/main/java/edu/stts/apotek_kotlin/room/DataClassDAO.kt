package edu.stts.apotek_kotlin.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataClassDAO {

    @Query("SELECT * FROM PrincipalPresenter")
    fun getAllPrincipal(): List<DataClassModel.Principal>
    @Insert
    fun insertAllPrincipal(vararg users: DataClassModel.Principal)
    @Query("SELECT * FROM PrincipalPresenter WHERE idPrincipal IN (:principalID)")
    fun loadAllByIdsPrincipal(principalID: IntArray): List<DataClassModel.Principal>
    @Delete
    fun deletePrincipal(id: DataClassModel.Principal)

    @Query("SELECT * FROM Produk")
    fun getAllProduk(): List<DataClassModel.Produk>
    @Insert
    fun insertAllProduk(vararg users: DataClassModel.Produk)
    @Query("SELECT * FROM Produk WHERE idProduk IN (:id)")
    fun loadAllByIdsProduk(id: IntArray): List<DataClassModel.Produk>
    @Delete
    fun deleteProduk(id: DataClassModel.Produk)


    @Query("SELECT * FROM Category")
    fun getAllKategori(): List<DataClassModel.Category>
    @Insert
    fun insertAllCategory(vararg users: DataClassModel.Category)
    @Query("SELECT * FROM Category WHERE idKategori IN (:id)")
    fun loadAllByIdsKategori(id: IntArray): List<DataClassModel.Category>
    @Delete
    fun deleteCategory(id: DataClassModel.Category)

    @Query("SELECT * FROM BANK")
    fun getAllBank(): List<DataClassModel.Bank>
    @Insert
    fun insertAllBank(vararg users: DataClassModel.Bank)
    @Query("SELECT * FROM Bank WHERE id_bank IN (:id)")
    fun loadAllByIdsBank(id: IntArray): List<DataClassModel.Bank>
    @Delete
    fun deleteBank(id: DataClassModel.Bank)

    @Query("SELECT * FROM CITY")
    fun getAllCity(): List<DataClassModel.City>
    @Insert
    fun insertAllCity(vararg users: DataClassModel.City)
    @Query("SELECT * FROM City WHERE id_city IN (:id)")
    fun loadAllByIdsCity(id: IntArray): List<DataClassModel.City>
    @Delete
    fun deleteCity(id: DataClassModel.City)

    @Query("SELECT * FROM Kemasan")
    fun getAllKemasan(): List<DataClassModel.Kemasan>
    @Insert
    fun insertAllKemasan(vararg users: DataClassModel.Kemasan)
    @Query("SELECT * FROM Kemasan WHERE idKemasan IN (:id)")
    fun loadAllByIdsKemasan(id: IntArray): List<DataClassModel.Kemasan>
    @Delete
    fun deleteKemasan(id: DataClassModel.Kemasan)

    @Query("SELECT * FROM LokasiRak")
    fun getAllLokasiRak(): List<DataClassModel.LokasiRak>
    @Insert
    fun insertAllLokasiRak(vararg users: DataClassModel.LokasiRak)
    @Query("SELECT * FROM LokasiRak WHERE idLokasi IN (:id)")
    fun loadAllByIdsLokasiRak(id: IntArray): List<DataClassModel.LokasiRak>
    @Delete
    fun deleteLokasiRak(id: DataClassModel.LokasiRak)

    @Query("SELECT * FROM Supplier")
    fun getAllSupplier(): List<DataClassModel.Supplier>
    @Insert
    fun insertAllSupplier(vararg users: DataClassModel.Supplier)
    @Query("SELECT * FROM Supplier WHERE id_supplier IN (:id)")
    fun loadAllByIdsSupplier(id: IntArray): List<DataClassModel.Supplier>
    @Delete
    fun deleteSupplier(id: DataClassModel.Supplier)

}