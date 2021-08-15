package com.example.library.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Groups(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val klasRuk:String,
    val phone:String,
    val email:String
)