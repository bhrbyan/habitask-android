package id.habitask.feature.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.habitask.data.category.model.Category
import id.habitask.data.category.usecase.GetCategoriesUseCase
import id.habitask.data.category.usecase.SaveCategoriesUseCase
import id.habitask.data.category.usecase.SyncCategoriesUseCase
import id.habitask.network.state.Result
import id.habitask.storage.AppSettingSharedPref
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(TaskListState())
    val viewState: StateFlow<TaskListState>
        get() = _viewState.asStateFlow()

    private fun updateViewState(viewState: TaskListState) {
        _viewState.value = viewState
    }

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            when (val result = getCategoriesUseCase.invoke()) {
                is Result.Success<List<Category>> -> {
                    updateViewState(TaskListState(result.data))
                }
                is Result.Failed -> {
                    // TODO: Do something
                }
            }
        }
    }

}

data class TaskListState(
    val categories: List<Category> = emptyList()
)