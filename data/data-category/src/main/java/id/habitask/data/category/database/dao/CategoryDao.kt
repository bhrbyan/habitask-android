package id.habitask.data.category.database.dao

import androidx.room.Dao
import androidx.room.Query
import id.habitask.data.category.database.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category_entity")
    fun getCategories(): List<CategoryEntity>

}