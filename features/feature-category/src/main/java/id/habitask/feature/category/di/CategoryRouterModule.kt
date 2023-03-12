package id.habitask.feature.category.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import id.habitask.feature.category.router.CategoryIntentRouter
import id.habitask.feature.category.router.CategoryIntentRouterImpl

@Module
@InstallIn(ActivityComponent::class)
object CategoryIntentRouterModule {

    @Provides
    fun provideCategoryIntentRouter(): CategoryIntentRouter {
        return CategoryIntentRouterImpl()
    }

}