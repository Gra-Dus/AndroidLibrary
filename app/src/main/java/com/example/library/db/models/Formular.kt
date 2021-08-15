package com.example.library.db.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(indices = [Index("readerId"), Index("bookId")],
    foreignKeys = [ForeignKey(
        entity = Book::class,
        parentColumns = ["id"],
        childColumns = ["bookId"]
    ),
        ForeignKey(
            entity = Readers::class,
            parentColumns = ["id"],
            childColumns = ["readerId"]
        )]
)
class Formular(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val dataOut: String,
    val bookId: Int,
    val dataIn: String,
    val readerId: Int
)
