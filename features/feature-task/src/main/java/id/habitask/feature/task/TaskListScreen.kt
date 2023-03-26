package id.habitask.feature.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import id.habitask.feature.category.tab.CategoryTabList

@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier,
    taskListViewModel: TaskListViewModel = viewModel()
) {
    val viewState = taskListViewModel.viewState.collectAsState()

    Column(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CategoryTabList(
                categories = viewState.value.categories, modifier = Modifier.weight(1f)
            )
        }
    }
}