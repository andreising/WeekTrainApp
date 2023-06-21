package com.andrei_singeleytsev.sportquizapp.di

import android.app.Application

import androidx.room.Room
import com.andreisingeleytsev.weektrainapp.data.MainDataBase
import com.andreisingeleytsev.weektrainapp.data.repository.TrainingItemRepository
import com.andreisingeleytsev.weektrainapp.data.repository.UserItemRepository
import com.andreisingeleytsev.weektrainapp.data.repository.impl.TrainingItemRepositoryImpl
import com.andreisingeleytsev.weektrainapp.data.repository.impl.UserItemRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDatabase(app: Application): MainDataBase {
        return Room.databaseBuilder(
            app,
            MainDataBase::class.java,
            "sport_quiz_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserItemRepository(db: MainDataBase): UserItemRepository {
        return UserItemRepositoryImpl(db.userDao)
    }
    @Provides
    @Singleton
    fun provideUserTrainingRepository(db: MainDataBase): TrainingItemRepository {
        return TrainingItemRepositoryImpl(db.trainDao)
    }


}