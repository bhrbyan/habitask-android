package id.habitask.data.task.usecase

import id.habitask.data.task.model.Task
import id.habitask.data.task.repository.TaskDataSource
import id.habitask.network.state.Result
import javax.inject.Inject

class SaveTaskUseCase @Inject constructor(
    private val taskRepository: TaskDataSource
) {

    suspend operator fun invoke(task: Task): Result<Boolean> {
        return taskRepository.saveTask(task)
    }

}