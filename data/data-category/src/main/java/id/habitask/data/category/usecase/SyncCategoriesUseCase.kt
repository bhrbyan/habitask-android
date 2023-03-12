package id.habitask.data.category.usecase

import id.habitask.data.category.model.Category
import id.habitask.data.category.repository.CategoryDataSource
import id.habitask.network.state.Result
import javax.inject.Inject

class SyncCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryDataSource
) {

    suspend operator fun invoke(categories: List<Category>): Result<List<Category>> {
        return when (val result = categoryRepository.saveCategories(categories)) {
            is Result.Success -> {
                if (result.data) {
                    Result.Success(categories)
                } else {
                    Result.Failed(Exception("Failed to save categories"))
                }
            }
            is Result.Failed -> {
                Result.Failed(Exception("Failed to save categories"))
            }
        }
    }

}