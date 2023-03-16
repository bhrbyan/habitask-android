package id.habitask.data.category.model

import id.habitask.database.entity.CategoryEntity

data class Category(
    val name: String,
    val hexColor: String,
    val position: Int,
    var visible: Boolean,
    val deletable: Boolean = true,
    val id: Long = 0
) {
    fun mapToEntity(id: Long = 0): CategoryEntity {
        return CategoryEntity(id, name, hexColor, position, visible, deletable)
    }
}
