package com.andreisingeleytsev.weektrainapp.data.repository

import androidx.room.Query
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem

interface UserItemRepository {
    suspend fun insertItem(user: UserItem)
    suspend fun getUserItem(): UserItem
    suspend fun isFirstLaunch(): Boolean
}