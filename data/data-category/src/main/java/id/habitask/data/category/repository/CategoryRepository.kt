package id.habitask.data.category.repository

import id.habitask.data.category.database.dao.CategoryDao
import id.habitask.data.category.model.Category
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryDataSource {

    override fun getCategories(): List<Category> {
        return categoryDao.getCategories().map { categoryEntity ->
            with(categoryEntity) {
                Category(id, name, hexColor, position, visible, deletable)
            }
        }
    }

}