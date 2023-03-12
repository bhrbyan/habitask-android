package id.habitask.data.category.usecase

import id.habitask.data.category.model.Category
import id.habitask.network.state.Result
import id.habitask.data.category.repository.CategoryDataSource
import javax.inject.Inject

class SaveCategoriesUseCase @Inject constructor(private val categoryRepository: CategoryDataSource) {

    suspend operator fun invoke(categories: List<Category>): Result<Boolean> {
        return categoryRepository.saveCategories(categories)
    }

}