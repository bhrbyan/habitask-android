package id.habitask.feature.task.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.habitask.data.task.usecase.CheckTaskUseCase
import id.habitask.data.task.usecase.GetTasksUseCase
import id.habitask.feature.task.list.state.TaskListViewState
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val checkTaskUseCase: CheckTaskUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(TaskListViewState())
    val viewState: StateFlow<TaskListViewState> = _viewState.asStateFlow()

    init {
        getTasks()
    }

    private fun getTasks() {
        viewModelScope.launch {
            getTasksUseCase.invoke().collect { result ->
                when (result) {
                    is Result.Success -> {
                        _viewState.value = TaskListViewState(result.data)
                    }
                    is Result.Failed -> {
                        Log.d("ERROR MESSAGE", result.exception.localizedMessage.orEmpty())
                    }
                }
            }
        }
    }

    fun onCheck(id: Long, check: Boolean) {
        viewModelScope.launch {
            when (checkTaskUseCase.invoke(id, check)) {
                is Result.Success -> {
                    // Do nothing
                }
                is Result.Failed -> {
                    TODO()
                }
            }

        }
    }

}