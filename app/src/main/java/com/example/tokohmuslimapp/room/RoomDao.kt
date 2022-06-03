package com.example.tokohmuslimapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tokohmuslimapp.model.TokohItem

@Dao
interface RoomDao {

    @Query("SELECT * FROM item WHERE type = :type")
    fun getDatabyType(type : String) : LiveData<List<TokohItem>>

    @Query("DELETE FROM item")
    suspend fun resetDatabase()

    @Query("DELETE FROM item WHERE type = :type")
    suspend fun resetType(type: String)

    @Insert
    suspend fun insertData(data: List<TokohItem>)

    @Delete
    suspend fun deleteData(data: TokohItem)

}