package com.andreisingeleytsev.weektrainapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem

@Dao
interface UserItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(user: UserItem)
    @Query("SELECT * FROM user_item WHERE id IS 1")
    suspend fun getUserItem():UserItem
}