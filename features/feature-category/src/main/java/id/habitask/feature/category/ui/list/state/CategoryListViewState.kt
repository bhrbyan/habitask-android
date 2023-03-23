package id.habitask.feature.category.ui.list.state

import id.habitask.data.category.model.Category

data class CategoryListViewState(
    val categories: List<Category> = emptyList()
)
