package id.habitask.data.category.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.habitask.data.category.repository.CategoryDataSource
import id.habitask.data.category.repository.CategoryRepository
import id.habitask.database.AppDatabase
import id.habitask.database.dao.CategoryDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryDaoModule {

    @Singleton
    @Provides
    fun provideCategoryDao(@ApplicationContext context: Context): CategoryDao {
        return AppDatabase.getInstance(context).categoryDao()
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class CategoryRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindCategoryRepository(categoryRepository: CategoryRepository): CategoryDataSource

}