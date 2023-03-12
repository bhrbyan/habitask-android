package id.habitask.data.category.helper

import id.habitask.data.category.model.Category

interface CategoryHelper {

    fun getDefaultCategories(): List<Category>

}