package id.habitask.data.task.usecase

import id.habitask.data.task.model.Task
import id.habitask.data.task.model.TaskStatus
import id.habitask.data.task.repository.TaskDataSource
import id.habitask.network.state.Result
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val taskRepository: TaskDataSource
) {

    suspend operator fun invoke(taskStatus: TaskStatus): Result<List<Task>> {
        return taskRepository.getTasks(taskStatus)
    }

}