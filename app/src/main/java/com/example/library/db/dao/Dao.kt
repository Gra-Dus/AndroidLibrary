package com.example.library.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.library.db.models.Book
import com.example.library.db.models.CountReaders

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCounter(countReaders: CountReaders)

    @Query("SELECT * FROM CountReaders")
    fun getCounters():List<CountReaders>

    @Query("SELECT * FROM CountReaders where date==:date")
    fun getCounterByDate(date:Int):CountReaders
}