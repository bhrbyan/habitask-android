package id.habitask.data.category.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.habitask.database.dao.CategoryDao
import id.habitask.data.category.repository.CategoryDataSource
import id.habitask.data.category.repository.CategoryRepository
import id.habitask.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryDatabaseModule {

    @Singleton
    @Provides
    fun provideCategoryDatabase(@ApplicationContext context: Context): CategoryDao {
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