package id.habitask.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.habitask.database.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category_entity")
    suspend fun getCategories(): List<CategoryEntity>

    @Insert
    suspend fun saveCategory(category: CategoryEntity)

}