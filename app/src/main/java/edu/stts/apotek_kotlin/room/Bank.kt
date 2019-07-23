package edu.stts.apotek_kotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bank(
    @PrimaryKey
    @ColumnInfo(name = "id_bank") val idBank: String,
    @ColumnInfo(name = "name") val name: String
)