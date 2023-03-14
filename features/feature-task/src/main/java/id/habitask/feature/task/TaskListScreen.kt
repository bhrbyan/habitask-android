package id.habitask.feature.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import id.habitask.feature.category.tab.CategoryTabList
import id.habitask.ui.Toolbar
import id.habitask.ui.R

@Composable
fun TaskListScreen(
    onOpenMoreCategories: () -> Unit,
    modifier: Modifier = Modifier,
    taskListViewModel: TaskListViewModel = viewModel()
) {
    val viewState = taskListViewModel.viewState.collectAsState()

    Column(modifier) {
        Toolbar(title = R.string.app_name, modifier)
        Row(verticalAlignment = Alignment.CenterVertically) {
            CategoryTabList(
                categories = viewState.value.categories, modifier = Modifier.weight(1f)
            )
            Image(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                modifier = Modifier.clickable {
                    onOpenMoreCategories()
                }
            )
        }
    }
}