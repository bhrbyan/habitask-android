package id.habitask.feature.task.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.habitask.data.task.model.TaskStatus
import id.habitask.data.task.usecase.CheckAndGetLatestTaskUseCase
import id.habitask.data.task.usecase.GetTasksUseCase
import id.habitask.feature.task.list.state.TaskListViewState
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val checkAndGetLatestTaskUseCase: CheckAndGetLatestTaskUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(TaskListViewState())
    val viewState: StateFlow<TaskListViewState> = _viewState.asStateFlow()

    init {
        getTasks()
    }

    private fun getTasks() {
        viewModelScope.launch {
            when (val result = getTasksUseCase.invoke(TaskStatus.All)) {
                is Result.Success -> {
                    _viewState.value = TaskListViewState(result.data)
                }
                is Result.Failed -> {
                    // TODO
                }
            }
        }
    }

    fun onCheck(id: Long, check: Boolean) {
        viewModelScope.launch {
            when (val result = checkAndGetLatestTaskUseCase.invoke(id, check)) {
                is Result.Success -> {
                    _viewState.update {
                        it.copy(
                            tasks = result.data
                        )
                    }
                }
                is Result.Failed -> {
                    TODO()
                }
            }

        }
    }

}