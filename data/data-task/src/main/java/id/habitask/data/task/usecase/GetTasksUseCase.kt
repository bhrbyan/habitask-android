package id.habitask.data.task.usecase

import id.habitask.data.task.model.Task
import id.habitask.data.task.repository.TaskDataSource
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val taskRepository: TaskDataSource
) {

    operator fun invoke(): Flow<Result<List<Task>>> {
        return taskRepository.getTasks()
    }

}