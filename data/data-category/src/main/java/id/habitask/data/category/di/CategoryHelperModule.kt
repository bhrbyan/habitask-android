package id.habitask.data.category.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.habitask.data.category.helper.CategoryHelper
import id.habitask.data.category.helper.CategoryHelperImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryHelperModule {

    @Singleton
    @Provides
    fun provideCategoryHelper(@ApplicationContext context: Context): CategoryHelper {
        return CategoryHelperImpl(context)
    }

}