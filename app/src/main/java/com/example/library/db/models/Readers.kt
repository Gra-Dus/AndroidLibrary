package com.example.library.db.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    foreignKeys = [ForeignKey(
        entity = Groups::class,
        parentColumns = ["id"],
        childColumns = ["groupId"]
    )]
)
class Readers(
    @PrimaryKey(autoGenerate = true)
    val groupId: Int,
    val secondName: String,
    val FirsName: String,
    val year: String
)