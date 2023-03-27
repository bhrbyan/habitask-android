package id.habitask.data.task.repository

import id.habitask.data.task.model.Task
import id.habitask.data.task.model.TaskStatus
import id.habitask.network.state.Result

interface TaskDataSource {

    suspend fun saveTask(task: Task): Result<Boolean>
    suspend fun getTasks(taskStatus: TaskStatus): Result<List<Task>>
    suspend fun checkTask(id: Long, checked: Boolean): Result<Boolean>

}