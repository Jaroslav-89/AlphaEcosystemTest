package com.example.alphaecosystemtest.common.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alphaecosystemtest.common.data.db.dao.HistoryDAO

@Database(
    version = 1,
    entities = [
    ]
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun historyDao(): HistoryDAO
}