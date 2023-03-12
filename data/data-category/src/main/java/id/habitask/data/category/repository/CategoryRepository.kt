package id.habitask.data.category.repository

import id.habitask.data.category.model.Category
import id.habitask.database.dao.CategoryDao
import id.habitask.network.dispatcher.AppDispatcher
import id.habitask.network.state.Result
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val appDispatcher: AppDispatcher,
    private val categoryDao: CategoryDao
) : CategoryDataSource {

    override suspend fun getCategories(): Result<List<Category>> {
        return withContext(appDispatcher.io) {
            try {
                val categories = categoryDao.getCategories().map { categoryEntity ->
                    with(categoryEntity) {
                        Category(name, hexColor, position, visible, deletable)
                    }
                }

                Result.Success(categories)
            } catch (e: Exception) {
                Result.Failed(e)
            }
        }
    }

    override suspend fun saveCategories(categories: List<Category>): Result<Boolean> {
        return withContext(appDispatcher.io) {
            try {
                categories.forEach { category ->
                    categoryDao.saveCategory(category.mapToEntity())
                }

                Result.Success(true)
            } catch (e: Exception) {
                Result.Failed(e)
            }
        }
    }
}