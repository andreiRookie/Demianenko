package com.andreirookie.moviesapp.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieEntity ORDER BY id DESC")
    fun getAllSaved(): List<MovieEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieEntity)
//    @Insert
//    fun insert(movie: List<MovieEntity>)
    @Query("DELETE FROM MovieEntity WHERE id = :movieId")
    fun remove(movieId: Int)
}