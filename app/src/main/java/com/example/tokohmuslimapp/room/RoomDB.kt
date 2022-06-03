package com.example.tokohmuslimapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tokohmuslimapp.model.PenemuItem
import com.example.tokohmuslimapp.model.TokohItem

@Database(entities = [TokohItem::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {
    abstract fun roomDao() : RoomDao

    companion object {

        private var roomdatabaseitem : RoomDB? = null

        fun getRoomDatabaseItem(context: Context): RoomDB{
            return roomdatabaseitem ?: synchronized(this) {
                roomdatabaseitem ?: Room.databaseBuilder(context,RoomDB::class.java, "item.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
    }

}