package id.habitask.feature.task.bottomsheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.habitask.data.task.model.Task
import id.habitask.data.task.usecase.SaveTaskUseCase
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskBottomSheetFormViewModel @Inject constructor(
    private val saveTaskUseCase: SaveTaskUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(false)
    val viewState: StateFlow<Boolean> = _viewState.asStateFlow()

    fun saveTask(taskValue: String) {
        viewModelScope.launch {
            when (val result = saveTaskUseCase.invoke(Task(0, taskValue, 1, false))) {
                is Result.Success -> {
                    _viewState.value = result.data
                }
                is Result.Failed -> {
                    // TODO: Do something
                }
            }
        }
    }

    fun resetState() {
        _viewState.update { false }
    }

}