package id.habitask.data.task.repository

import id.habitask.data.task.model.Task
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.Flow

interface TaskDataSource {

    suspend fun saveTask(task: Task): Result<Boolean>
    fun getTasks(): Flow<Result<List<Task>>>
    suspend fun checkTask(id: Long, checked: Boolean): Result<Boolean>

}