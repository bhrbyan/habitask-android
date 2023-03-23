package id.habitask.feature.category.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.habitask.data.category.model.Category
import id.habitask.data.category.model.CategoryGetRequest
import id.habitask.data.category.usecase.GetCategoriesUseCase
import id.habitask.data.category.usecase.UpdateThenGetCategoriesUseCase
import id.habitask.feature.category.ui.list.state.CategoryListViewState
import id.habitask.network.state.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val updateThenGetCategoriesUseCase: UpdateThenGetCategoriesUseCase
) : ViewModel() {

    private val _viewState: MutableStateFlow<CategoryListViewState> =
        MutableStateFlow(CategoryListViewState())
    val viewState: StateFlow<CategoryListViewState> = _viewState.asStateFlow()

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            when (val result = getCategoriesUseCase.invoke(CategoryGetRequest.All)) {
                is Result.Success -> {
                    _viewState.value = CategoryListViewState(result.data)
                }
                is Result.Failed -> {
                    // TODO: Do something
                }
            }
        }
    }

    fun updateVisibility(category: Category) {
        viewModelScope.launch {
            when (val result = updateThenGetCategoriesUseCase.invoke(category)) {
                is Result.Success -> {
                    _viewState.update { currentState ->
                        currentState.copy(
                            categories = result.data
                        )
                    }

                }
                is Result.Failed -> {
                    // TODO: Do something
                }
            }
        }
    }

}