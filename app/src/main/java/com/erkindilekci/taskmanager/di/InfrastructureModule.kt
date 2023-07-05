package com.erkindilekci.taskmanager.di

import android.app.Application
import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.providers.StringResourceProvider
import com.erkindilekci.taskmanager.domain.providers.WorkerProvider
import com.erkindilekci.taskmanager.infrastructure.providers.string.StringResourceProviderImpl
import com.erkindilekci.taskmanager.infrastructure.providers.worker.TaskWorkerProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InfrastructureModule {

    @Provides
    @Singleton
    fun provideStringResourceProvider(application: Application): StringResourceProvider {
        return StringResourceProviderImpl(application)
    }

    @Provides
    @Singleton
    fun provideTaskWorkerProvider(application: Application): WorkerProvider<Task> {
        return TaskWorkerProviderImpl(application)
    }
}
