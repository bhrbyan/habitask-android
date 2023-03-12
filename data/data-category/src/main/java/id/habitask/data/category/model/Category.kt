package id.habitask.data.category.model

import id.habitask.database.entity.CategoryEntity

data class Category(
    val name: String,
    val hexColor: String,
    val position: Int,
    val visible: Boolean,
    val deletable: Boolean = true
) {
    fun mapToEntity(): CategoryEntity {
        return CategoryEntity(name, hexColor, position, visible, deletable)
    }
}
