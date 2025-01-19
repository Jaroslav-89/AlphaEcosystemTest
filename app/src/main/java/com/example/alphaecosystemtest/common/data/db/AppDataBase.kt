package com.example.alphaecosystemtest.common.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alphaecosystemtest.common.data.db.dao.HistoryDAO
import com.example.alphaecosystemtest.common.data.db.entity.CardInfoEntity

@Database(
    version = 2,
    entities = [CardInfoEntity::class],
    exportSchema = false,
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun historyDao(): HistoryDAO
}