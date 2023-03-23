package id.habitask.data.category.repository

import id.habitask.data.category.model.Category
import id.habitask.data.category.model.CategoryGetRequest
import id.habitask.database.dao.CategoryDao
import id.habitask.network.dispatcher.AppDispatcher
import id.habitask.network.state.Result
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val appDispatcher: AppDispatcher,
    private val categoryDao: CategoryDao
) : CategoryDataSource {

    override suspend fun getCategories(request: CategoryGetRequest): Result<List<Category>> {
        return withContext(appDispatcher.io) {
            try {
                val categories = when (request) {
                    is CategoryGetRequest.All -> {
                        categoryDao.getCategories()
                    }
                    is CategoryGetRequest.VisibleOnly -> {
                        categoryDao.getCategories().filter { it.visible }
                    }
                }.map {
                    Category(it.name, it.hexColor, it.position, it.visible, it.deletable, it.id)
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

    override suspend fun updateCategory(category: Category): Result<Boolean> {
        return withContext(appDispatcher.io) {
            try {
                val updatedCategory = category.copy(visible = !category.visible)

                categoryDao.updateCategory(
                    updatedCategory.mapToEntity(id = category.id)
                )

                Result.Success(true)
            } catch (e: Exception) {
                Result.Failed(e)
            }
        }
    }
}