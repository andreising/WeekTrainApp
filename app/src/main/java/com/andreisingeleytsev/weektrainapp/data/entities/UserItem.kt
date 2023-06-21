package com.andreisingeleytsev.weektrainapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_item")
data class UserItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val height: Int,
    val weight: Int,
    val wannaWeight: Int? = null
)
