package id.habitask.feature.task.list.state

import id.habitask.data.task.model.Task

data class TaskListViewState(
    val tasks: List<Task> = emptyList()
)