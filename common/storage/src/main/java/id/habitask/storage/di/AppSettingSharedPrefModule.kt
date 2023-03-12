package id.habitask.storage.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.habitask.storage.AppSettingSharedPref
import id.habitask.storage.AppSettingSharedPrefImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppSettingSharedPrefModule {

    @Provides
    @Singleton
    fun provideAppSettingSharedPref(@ApplicationContext context: Context): AppSettingSharedPref {
        return AppSettingSharedPrefImpl(context)
    }
}