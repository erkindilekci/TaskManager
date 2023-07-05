package com.erkindilekci.taskmanager.di

import com.erkindilekci.taskmanager.data.database.TaskDatabase
import com.erkindilekci.taskmanager.data.repository.TaskRepositoryImpl
import com.erkindilekci.taskmanager.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideTaskRepository(taskDatabase: TaskDatabase): TaskRepository {
        return TaskRepositoryImpl(taskDatabase.taskDAO)
    }
}
