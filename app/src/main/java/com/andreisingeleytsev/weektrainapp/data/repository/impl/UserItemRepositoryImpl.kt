package com.andreisingeleytsev.weektrainapp.data.repository.impl

import com.andreisingeleytsev.weektrainapp.data.dao.UserItemDao
import com.andreisingeleytsev.weektrainapp.data.entities.UserItem
import com.andreisingeleytsev.weektrainapp.data.repository.UserItemRepository

class UserItemRepositoryImpl(
    private val dao: UserItemDao
): UserItemRepository {
    override suspend fun insertItem(user: UserItem) {
        dao.insertItem(user)
    }

    override suspend fun getUserItem(): UserItem {
        return dao.getUserItem()
    }

    override suspend fun isFirstLaunch(): Boolean {
        return dao.getUserItem().wannaWeight==null
    }
}