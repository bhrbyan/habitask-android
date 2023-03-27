package id.habitask.data.task.repository

import id.habitask.data.task.model.Task
import id.habitask.database.dao.TaskDao
import id.habitask.network.dispatcher.AppDispatcher
import id.habitask.network.state.Result
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

    override suspend fun getTasks(): Result<List<Task>> {
        return withContext(dispatcher.io) {
            try {
                val tasks = taskDao.getTasks().map {
                    Task(it.id, it.name, it.categoryId)
                }

                Result.Success(tasks)
            } catch (e: Exception) {
                Result.Failed(e)
            }
        }
    }
}