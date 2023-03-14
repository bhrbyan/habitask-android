package id.habitask.feature.task

import id.habitask.data.category.model.Category

data class TaskListViewState(
    val categories: List<Category> = emptyList()
)