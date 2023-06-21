package com.andreisingeleytsev.weektrainapp.data.repository.impl

import com.andreisingeleytsev.weektrainapp.data.dao.TrainingItemDao
import com.andreisingeleytsev.weektrainapp.data.entities.TrainingItem
import com.andreisingeleytsev.weektrainapp.data.repository.TrainingItemRepository
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.CARDIO
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.CROSSFIT
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.POWER
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.STRETCHING
import com.andreisingeleytsev.weektrainapp.ui.screens.training_screen.YOGA

class TrainingItemRepositoryImpl(private val dao: TrainingItemDao): TrainingItemRepository {
    override suspend fun insertItem(trainingItem: TrainingItem) {
        dao.insertItem(trainingItem)
    }

    override suspend fun getCardio(): List<TrainingItem> {
        return dao.getCardio(CARDIO)
    }

    override suspend fun getPower(): List<TrainingItem> {
        return dao.getCardio(POWER)
    }

    override suspend fun getStretching(): List<TrainingItem> {
        return dao.getCardio(STRETCHING)
    }

    override suspend fun getYoga(): List<TrainingItem> {
        return dao.getCardio(YOGA)
    }

    override suspend fun getCrossfit(): List<TrainingItem> {
        return dao.getCardio(CROSSFIT)
    }
}