package edu.stts.apotek_kotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(
    @PrimaryKey
    @ColumnInfo(name = "id_city") val idCity: String,
    @ColumnInfo(name = "name") val name: String
)