package id.habitask.feature.category.ui.tab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.habitask.data.category.model.Category
import id.habitask.data.category.model.CategoryGetRequest
import id.habitask.data.category.usecase.GetCategoriesUseCase
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryTabViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(CategoryTabViewState())
    val viewState: StateFlow<CategoryTabViewState>
        get() = _viewState.asStateFlow()

    private fun updateViewState(viewState: CategoryTabViewState) {
        _viewState.value = viewState
    }

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            when (val result = getCategoriesUseCase.invoke(CategoryGetRequest.VisibleOnly)) {
                is Result.Success<List<Category>> -> {
                    updateViewState(CategoryTabViewState(result.data))
                }
                is Result.Failed -> {
                    // TODO: Do something
                }
            }
        }
    }

}