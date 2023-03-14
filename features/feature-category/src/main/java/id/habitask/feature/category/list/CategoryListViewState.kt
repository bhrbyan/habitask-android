package id.habitask.feature.category.list

import id.habitask.data.category.model.Category

data class CategoryListViewState(
    val categories: List<Category> = emptyList()
)
