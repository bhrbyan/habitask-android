package id.habitask.data.category.usecase

import id.habitask.data.category.helper.CategoryHelper
import id.habitask.data.category.model.Category
import id.habitask.data.category.repository.CategoryDataSource
import id.habitask.network.state.Result
import id.habitask.storage.AppSettingSharedPref
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryDataSource,
    private val appSharedPref: AppSettingSharedPref,
    private val syncCategoriesUseCase: SyncCategoriesUseCase,
    private val categoryHelper: CategoryHelper
) {

    suspend operator fun invoke(): Result<List<Category>> {
        return if (appSharedPref.firstTimeUser) {
            appSharedPref.firstTimeUser = false

            syncCategoriesUseCase.invoke(categoryHelper.getDefaultCategories())
        } else {
            categoryRepository.getCategories()
        }
    }

}