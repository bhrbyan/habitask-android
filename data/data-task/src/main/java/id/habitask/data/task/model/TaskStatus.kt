package id.habitask.data.task.model

sealed class TaskStatus {
    object All : TaskStatus()
    object Checked : TaskStatus()
    object Unchecked : TaskStatus()
}
