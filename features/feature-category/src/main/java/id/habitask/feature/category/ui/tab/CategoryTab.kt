package id.habitask.feature.category.ui.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import id.habitask.feature.category.tab.CategoryTabList

@Composable
fun CategoryTab(
    modifier: Modifier = Modifier,
    taskListViewModel: CategoryTabViewModel = viewModel()
) {
    val viewState = taskListViewModel.viewState.collectAsState()

    Column(modifier) {
        CategoryTabList(categories = viewState.value.categories)
    }
}