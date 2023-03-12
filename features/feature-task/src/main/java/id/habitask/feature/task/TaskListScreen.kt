package id.habitask.feature.task

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import id.habitask.data.category.helper.CategoryHelper
import id.habitask.feature.category.CategoryTabList
import id.habitask.storage.AppSettingSharedPref
import id.habitask.ui.Toolbar
import id.habitask.ui.R

@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier,
    taskListViewModel: TaskListViewModel = viewModel()
) {
    val viewState = taskListViewModel.viewState.collectAsState()

    Column(modifier) {
        Toolbar(title = R.string.app_name, modifier)
        CategoryTabList(
            categories = viewState.value.categories
        )
    }
}

@Preview(showBackground = true, heightDp = 900)
@Composable
fun PreviewTaskListScreen() {
    TaskListScreen()
}