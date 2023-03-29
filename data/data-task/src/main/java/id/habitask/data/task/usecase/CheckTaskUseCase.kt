package id.habitask.data.task.usecase

import id.habitask.data.task.repository.TaskDataSource
import id.habitask.network.state.Result
import javax.inject.Inject

class CheckTaskUseCase @Inject constructor(
    private val taskRepository: TaskDataSource
) {

    suspend operator fun invoke(id: Long, completed: Boolean): Result<Boolean> {
        return taskRepository.checkTask(id, completed)
    }

}