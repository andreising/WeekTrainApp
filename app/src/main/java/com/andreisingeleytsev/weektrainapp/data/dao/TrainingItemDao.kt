package com.andreisingeleytsev.weektrainapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreisingeleytsev.weektrainapp.data.entities.TrainingItem
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem

@Dao
interface TrainingItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(trainingItem: TrainingItem)
    @Query("SELECT * FROM training_item WHERE category IS :string")
    suspend fun getCardio(string: String): List<TrainingItem>
    @Query("SELECT * FROM training_item WHERE category IS :string")
    suspend fun getPower(string: String): List<TrainingItem>
    @Query("SELECT * FROM training_item WHERE category IS :string")
    suspend fun getStretching(string: String): List<TrainingItem>
    @Query("SELECT * FROM training_item WHERE category IS :string")
    suspend fun getYoga(string: String): List<TrainingItem>
    @Query("SELECT * FROM training_item WHERE category IS :string")
    suspend fun getCrossfit(string: String): List<TrainingItem>
}