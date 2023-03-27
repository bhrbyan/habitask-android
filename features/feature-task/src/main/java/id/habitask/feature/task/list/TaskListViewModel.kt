package id.habitask.feature.task.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.habitask.data.task.model.Task
import id.habitask.data.task.usecase.CheckTaskUseCase
import id.habitask.data.task.usecase.GetTasksUseCase
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
    private val checkTaskUseCase: CheckTaskUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(emptyList<Task>())
    val viewState: StateFlow<List<Task>> = _viewState.asStateFlow()

    init {
        getTasks()
    }

    private fun getTasks() {
        viewModelScope.launch {
            when (val result = getTasksUseCase.invoke()) {
                is Result.Success -> {
                    _viewState.value = result.data
                }
                is Result.Failed -> {
                    // TODO
                }
            }
        }
    }

    fun onCheck(id: Long, check: Boolean) {
        val checkedTask = _viewState.value.find { it.id == id }
        val checkedTaskPosition = _viewState.value.indexOf(checkedTask)
        val updatedTask = _viewState.value.drop(checkedTaskPosition)
        viewModelScope.launch {
            when (checkTaskUseCase.invoke(id, check)) {
                is Result.Success -> {
                    _viewState.update {
                        updatedTask
                    }
                }
                is Result.Failed -> {
                    TODO()
                }
            }
        }
    }

}