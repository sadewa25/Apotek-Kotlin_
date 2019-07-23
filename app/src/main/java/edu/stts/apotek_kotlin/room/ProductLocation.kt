package edu.stts.apotek_kotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductLocation(
    @PrimaryKey
    @ColumnInfo(name = "id_location") val idLocation: String,
    @ColumnInfo(name = "name") val name: String
)