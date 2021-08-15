package com.example.library.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val YDK: String,
    val inventarId: String,
    val name: String,
    val year: String,
    val authors: String,
    val publisher:String,
    val razdel:String
)