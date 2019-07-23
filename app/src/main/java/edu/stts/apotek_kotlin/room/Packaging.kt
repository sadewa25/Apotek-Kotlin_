package edu.stts.apotek_kotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Packaging(
    @PrimaryKey
    @ColumnInfo(name = "id_packaging") val idPackaging: String,
    @ColumnInfo(name = "name") val name: String
)