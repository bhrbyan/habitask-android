package id.habitask.data.task.repository

import id.habitask.data.task.model.Task
import id.habitask.database.dao.TaskDao
import id.habitask.network.dispatcher.AppDispatcher
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao, private val dispatcher: AppDispatcher
) : TaskDataSource {

    override suspend fun saveTask(task: Task): Result<Boolean> {
        return withContext(dispatcher.io) {
            try {
                taskDao.saveTask(task.mapToEntity())

                Result.Success(true)
            } catch (e: Exception) {
                Result.Failed(e)
            }
        }
    }

    override fun getTasks(): Flow<Result<List<Task>>> {
        return taskDao.getTasks().flowOn(dispatcher.io)
            .map { tasksEntity ->
                val tasks = tasksEntity
                    .map {
                        Task(it.id, it.name, it.categoryId, it.checked)
                    }
                    .sortedByDescending { it.id }
                    .sortedBy { it.checked }

                Result.Success(tasks)
            }
            .catch { e ->
                Result.Failed(Exception(e))
            }
    }

    override suspend fun checkTask(id: Long, checked: Boolean): Result<Boolean> {
        return withContext(dispatcher.io) {
            try {
                taskDao.checkTask(id, checked)

                Result.Success(true)
            } catch (e: Exception) {
                Result.Failed(e)
            }
        }
    }
}