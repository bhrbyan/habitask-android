package id.habitask.data.category.repository

import id.habitask.data.category.model.Category
import id.habitask.data.category.model.CategoryGetRequest
import id.habitask.network.state.Result

interface CategoryDataSource {
    suspend fun getCategories(request: CategoryGetRequest): Result<List<Category>>
    suspend fun saveCategories(categories: List<Category>): Result<Boolean>
    suspend fun updateCategory(category: Category): Result<Boolean>

}