package id.habitask.feature.category.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.habitask.data.category.usecase.GetCategoriesUseCase
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(CategoryListViewState())
    val viewState: StateFlow<CategoryListViewState>
        get() = _viewState.asStateFlow()

    init {
        getCategories()
    }

    private fun updateViewState(viewState: CategoryListViewState) {
        _viewState.value = viewState
    }

    private fun getCategories() {
        viewModelScope.launch {
            when (val result = getCategoriesUseCase.invoke()) {
                is Result.Success -> {
                    updateViewState(CategoryListViewState(result.data))
                }
                is Result.Failed -> {
                    // TODO: Do something
                }
            }
        }
    }
}