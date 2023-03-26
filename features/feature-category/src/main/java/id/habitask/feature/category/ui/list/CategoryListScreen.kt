package id.habitask.feature.category.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CategoryListScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoryListViewModel = viewModel()
) {
    val viewState = viewModel.viewState.collectAsState()

    Column(modifier) {
        CategoryList(
            categories = viewState.value.categories,
            onUpdateVisibility = { selectedCategory ->
                viewModel.updateVisibility(selectedCategory)
            }
        )
    }
}