package id.habitask.data.task.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.habitask.data.task.repository.TaskDataSource
import id.habitask.data.task.repository.TaskRepository
import id.habitask.database.AppDatabase
import id.habitask.database.dao.TaskDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TaskDaoModule {

    @Singleton
    @Provides
    fun provideTaskDao(@ApplicationContext context: Context): TaskDao {
        return AppDatabase.getInstance(context).taskDao()
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class TaskRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindTaskRepository(taskRepository: TaskRepository): TaskDataSource

}