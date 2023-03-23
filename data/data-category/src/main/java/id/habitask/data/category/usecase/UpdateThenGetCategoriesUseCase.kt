package id.habitask.data.category.usecase

import id.habitask.data.category.model.Category
import id.habitask.data.category.model.CategoryGetRequest
import id.habitask.data.category.repository.CategoryDataSource
import id.habitask.network.state.Result
import javax.inject.Inject

class UpdateThenGetCategoriesUseCase @Inject constructor(private val categoryRepository: CategoryDataSource) {

    suspend operator fun invoke(category: Category): Result<List<Category>> {
        val result = when (categoryRepository.updateCategory(category)) {
            is Result.Success -> {
                categoryRepository.getCategories(CategoryGetRequest.All)
            }
            is Result.Failed -> {
                Result.Failed(Exception())
            }
        }

        return result
    }

}