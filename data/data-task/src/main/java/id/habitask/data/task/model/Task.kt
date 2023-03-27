package id.habitask.data.task.model

import id.habitask.database.entity.TaskEntity

data class Task(
    val id: Long,
    val name: String,
    val categoryId: Long,
    val checked: Boolean
) {
    fun mapToEntity(): TaskEntity {
        return TaskEntity(id, name, categoryId, checked)
    }
}
