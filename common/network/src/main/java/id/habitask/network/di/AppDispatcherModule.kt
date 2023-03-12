package id.habitask.network.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.habitask.network.dispatcher.AppDispatcher
import id.habitask.network.dispatcher.AppDispatcherImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDispatcherModule {

    @Singleton
    @Provides
    fun provideDispatcher(): AppDispatcher {
        return AppDispatcherImpl()
    }

}