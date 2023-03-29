package id.habitask.data.task.repository

import id.habitask.data.task.model.Task
import id.habitask.data.task.model.TaskStatus
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

    override suspend fun getTasks(taskStatus: TaskStatus): Result<List<Task>> {
        return withContext(dispatcher.io) {
            try {
                val tasks = taskDao.getTasks()
                    .filter {
                        when (taskStatus) {
                            TaskStatus.All -> it.checked.not() || it.checked
                            TaskStatus.Checked -> it.checked
                            TaskStatus.Unchecked -> it.checked.not()
                        }
                    }
                    .map {
                        Task(it.id, it.name, it.categoryId, it.checked)
                    }
                    .sortedBy { it.checked }

                Result.Success(tasks)
            } catch (e: Exception) {
                Result.Failed(e)
            }
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