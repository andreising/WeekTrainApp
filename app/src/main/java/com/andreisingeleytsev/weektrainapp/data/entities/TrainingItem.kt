package com.andreisingeleytsev.weektrainapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_item")
data class TrainingItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val category: String,
    val difficulty: String,
    val time: String
)
