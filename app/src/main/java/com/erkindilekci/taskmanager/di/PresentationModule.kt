package com.erkindilekci.taskmanager.di

import com.erkindilekci.taskmanager.domain.model.Task
import com.erkindilekci.taskmanager.domain.providers.StringResourceProvider
import com.erkindilekci.taskmanager.domain.providers.WorkerProvider
import com.erkindilekci.taskmanager.domain.repository.TaskRepository
import com.erkindilekci.taskmanager.domain.usecases.format.date.FormatDateUseCase
import com.erkindilekci.taskmanager.domain.usecases.format.date.FormatDateUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.format.time.FormatTimeUseCase
import com.erkindilekci.taskmanager.domain.usecases.format.time.FormatTimeUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.shedule.cancel.CancelScheduleTaskUseCase
import com.erkindilekci.taskmanager.domain.usecases.shedule.cancel.CancelScheduleTaskUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.shedule.shedule.ScheduleTaskUseCase
import com.erkindilekci.taskmanager.domain.usecases.shedule.shedule.ScheduleTaskUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.task.delete.DeleteTaskUseCase
import com.erkindilekci.taskmanager.domain.usecases.task.delete.DeleteTaskUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.task.edit.EditTaskUseCase
import com.erkindilekci.taskmanager.domain.usecases.task.edit.EditTaskUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.task.filter.FilterTaskUseCase
import com.erkindilekci.taskmanager.domain.usecases.task.filter.FilterTaskUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.task.get.GetTaskByIdUseCase
import com.erkindilekci.taskmanager.domain.usecases.task.get.GetTaskByIdUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.task.get_all.GetAllTaskUseCase
import com.erkindilekci.taskmanager.domain.usecases.task.get_all.GetAllTaskUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.task.save.SaveTaskUseCase
import com.erkindilekci.taskmanager.domain.usecases.task.save.SaveTaskUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.task.search.SearchTaskUseCase
import com.erkindilekci.taskmanager.domain.usecases.task.search.SearchTaskUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.validate.input.ValidateInputsUseCase
import com.erkindilekci.taskmanager.domain.usecases.validate.input.ValidateInputsUseCaseImpl
import com.erkindilekci.taskmanager.domain.usecases.validate.shedule.ValidateScheduleTimeUseCase
import com.erkindilekci.taskmanager.domain.usecases.validate.shedule.ValidateScheduleTimeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    @Singleton
    fun provideScheduleTaskUseCase(workerProvider: WorkerProvider<Task>): ScheduleTaskUseCase {
        return ScheduleTaskUseCaseImpl(workerProvider)
    }

    @Provides
    @Singleton
    fun provideCancelScheduleTaskUseCase(workerProvider: WorkerProvider<Task>): CancelScheduleTaskUseCase {
        return CancelScheduleTaskUseCaseImpl(workerProvider)
    }

    @Provides
    @Singleton
    fun provideGetAllTaskUseCase(repository: TaskRepository): GetAllTaskUseCase {
        return GetAllTaskUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetTaskByIdUseCase(repository: TaskRepository): GetTaskByIdUseCase {
        return GetTaskByIdUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSearchTaskUseCase(repository: TaskRepository): SearchTaskUseCase {
        return SearchTaskUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideFilterTaskUseCase(repository: TaskRepository): FilterTaskUseCase {
        return FilterTaskUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun ValidateInputsUseCase(stringResourceProvider: StringResourceProvider): ValidateInputsUseCase {
        return ValidateInputsUseCaseImpl(stringResourceProvider)
    }

    @Provides
    @Singleton
    fun ValidateScheduleTimeUseCase(stringResourceProvider: StringResourceProvider): ValidateScheduleTimeUseCase {
        return ValidateScheduleTimeUseCaseImpl(stringResourceProvider)
    }

    @Provides
    @Singleton
    fun provideSaveTaskUseCase(
        repository: TaskRepository,
        scheduleTaskUseCase: ScheduleTaskUseCase,
        cancelScheduleTaskUseCase: CancelScheduleTaskUseCase,
        validateInputsUseCase: ValidateInputsUseCase,
        validateScheduleTimeUseCase: ValidateScheduleTimeUseCase
    ): SaveTaskUseCase {
        return SaveTaskUseCaseImpl(
            repository,
            scheduleTaskUseCase,
            cancelScheduleTaskUseCase,
            validateInputsUseCase,
            validateScheduleTimeUseCase
        )
    }

    @Provides
    @Singleton
    fun provideEditTaskUseCase(
        repository: TaskRepository,
        scheduleTaskUseCase: ScheduleTaskUseCase,
        cancelScheduleTaskUseCase: CancelScheduleTaskUseCase,
        validateInputsUseCase: ValidateInputsUseCase,
        validateScheduleTimeUseCase: ValidateScheduleTimeUseCase
    ): EditTaskUseCase {
        return EditTaskUseCaseImpl(
            repository,
            scheduleTaskUseCase,
            cancelScheduleTaskUseCase,
            validateInputsUseCase,
            validateScheduleTimeUseCase
        )
    }

    @Provides
    @Singleton
    fun provideDeleteTaskUseCase(
        repository: TaskRepository,
        cancelScheduleTaskUseCase: CancelScheduleTaskUseCase
    ): DeleteTaskUseCase {
        return DeleteTaskUseCaseImpl(repository, cancelScheduleTaskUseCase)
    }

    @Provides
    @Singleton
    fun provideFormatDateUseCase(): FormatDateUseCase {
        return FormatDateUseCaseImpl()
    }

    @Provides
    @Singleton
    fun provideFormatTimeUseCase(): FormatTimeUseCase {
        return FormatTimeUseCaseImpl()
    }
}
