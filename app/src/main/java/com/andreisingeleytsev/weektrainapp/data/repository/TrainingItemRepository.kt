package com.andreisingeleytsev.weektrainapp.data.repository

import androidx.room.Query
import com.andreisingeleytsev.weektrainapp.data.entities.TrainingItem
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem

interface TrainingItemRepository {
    suspend fun insertItem(trainingItem: TrainingItem)
    suspend fun getCardio(): List<TrainingItem>
    suspend fun getPower(): List<TrainingItem>
    suspend fun getStretching(): List<TrainingItem>
    suspend fun getYoga(): List<TrainingItem>
    suspend fun getCrossfit(): List<TrainingItem>
}