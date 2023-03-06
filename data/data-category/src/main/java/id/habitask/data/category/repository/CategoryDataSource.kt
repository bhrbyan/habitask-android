package id.habitask.data.category.repository

import id.habitask.data.category.model.Category

interface CategoryDataSource {
    fun getCategories(): List<Category>
}