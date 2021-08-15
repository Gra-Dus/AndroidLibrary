package com.example.library.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.library.db.dao.Dao
import com.example.library.db.models.*

@Database(entities = [Book::class,CountReaders::class, Formular::class, Groups::class, Readers::class],version = 1 )
abstract class AppDataBase:RoomDatabase() {
    abstract fun dao(): Dao
    companion object{
        var INSTANCE:AppDataBase?=null
        fun getAppDataBase(context: Context):AppDataBase?{
            if(INSTANCE==null){
                synchronized(AppDataBase::class){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,AppDataBase::class.java,"myDB").build()
                }
            }
            return INSTANCE
        }
        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}