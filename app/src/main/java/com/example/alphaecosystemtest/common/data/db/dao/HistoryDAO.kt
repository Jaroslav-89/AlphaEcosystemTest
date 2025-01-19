package com.example.alphaecosystemtest.common.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.alphaecosystemtest.common.data.db.entity.CardInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardInfo(cardInfo: CardInfoEntity)

    @Query("SELECT * FROM card_info_table ORDER BY add_date DESC")
    fun getAllCardsInfo(): Flow<List<CardInfoEntity>>
}