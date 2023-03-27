package id.habitask.data.task.model

sealed class TaskStatus {
    object Checked : TaskStatus()
    object Unchecked : TaskStatus()
}
