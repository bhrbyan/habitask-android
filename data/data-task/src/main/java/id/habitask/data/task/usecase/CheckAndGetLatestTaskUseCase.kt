package id.habitask.data.task.usecase

import id.habitask.data.task.model.Task
import id.habitask.data.task.model.TaskStatus
import id.habitask.data.task.repository.TaskDataSource
import id.habitask.network.state.Result
import javax.inject.Inject

class CheckAndGetLatestTaskUseCase @Inject constructor(
    private val taskRepository: TaskDataSource,
    private val getTasksUseCase: GetTasksUseCase
) {

    suspend operator fun invoke(id: Long, completed: Boolean): Result<List<Task>> {
        val result = when (taskRepository.checkTask(id, completed)) {
            is Result.Success -> {
                getTasksUseCase.invoke(TaskStatus.Unchecked)
            }
            is Result.Failed -> {
                Result.Failed(Exception())
            }
        }

        return result
    }

}