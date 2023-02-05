package com.andreirookie.moviesapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDb :RoomDatabase()  {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var dbInstance: AppDb? = null

        fun getInstance(context: Context): AppDb {

            return dbInstance ?: synchronized(this) {
                dbInstance ?: buildDb(context).also { dbInstance = it }
            }
        }

        private fun buildDb(context: Context) : AppDb {
            return Room.databaseBuilder(context, AppDb::class.java,"app.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()



        }

    }
}