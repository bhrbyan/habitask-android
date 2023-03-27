package id.habitask.feature.task.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TaskList(
    modifier: Modifier = Modifier,
    viewModel: TaskListViewModel = viewModel()
) {
    val viewState by viewModel.viewState.collectAsState()
    var checked by remember {
        mutableStateOf(false)
    }

    LazyColumn(modifier) {
        items(viewState.tasks) { task ->
            TaskListItem(
                taskName = task.name,
                checked = checked,
                onCheckedChange = {
                    checked = !checked
                    viewModel.onCheck(task.id, checked)
                }
            )
        }
    }
}