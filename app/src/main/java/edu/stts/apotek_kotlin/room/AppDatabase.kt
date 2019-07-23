package edu.stts.apotek_kotlin.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(
    DataClassModel.Principal::class,
    DataClassModel.Category::class,
    DataClassModel.Kemasan::class,
    DataClassModel.LokasiRak::class,
    DataClassModel.Produk::class,
    DataClassModel.Supplier::class,
    DataClassModel.City::class,
    DataClassModel.Bank::class
    ), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): DataClassDAO
}