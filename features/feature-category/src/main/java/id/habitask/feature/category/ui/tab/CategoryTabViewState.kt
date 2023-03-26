package id.habitask.feature.category.ui.tab

import id.habitask.data.category.model.Category

data class CategoryTabViewState(
    val categories: List<Category> = emptyList()
)