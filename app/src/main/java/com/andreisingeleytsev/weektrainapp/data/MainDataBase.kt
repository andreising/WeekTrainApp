package com.andreisingeleytsev.weektrainapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andreisingeleytsev.weektrainapp.data.dao.TrainingItemDao
import com.andreisingeleytsev.weektrainapp.data.dao.UserItemDao
import com.andreisingeleytsev.weektrainapp.data.entities.TrainingItem
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem

@Database(
    entities = [TrainingItem::class, UserItem::class],
    version = 1
)
abstract class MainDataBase: RoomDatabase() {
    abstract val userDao: UserItemDao
    abstract val trainDao: TrainingItemDao
}