package com.example.library.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CountReaders(
    @PrimaryKey(autoGenerate = true)
    val date: Int,
    val count: String
)