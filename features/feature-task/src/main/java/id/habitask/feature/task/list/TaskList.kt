package id.habitask.feature.task.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TaskList(
    modifier: Modifier = Modifier,
    viewModel: TaskListViewModel = viewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    var isTodaySectionExpanded by rememberSaveable {
        mutableStateOf(true)
    }

    Surface(modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 20.dp),
            shape = CircleShape.copy(CornerSize(16.dp))
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = id.habitask.ui.R.string.task_list_caption),
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h5
                    )
                    IconButton(
                        onClick = {
                            isTodaySectionExpanded = !isTodaySectionExpanded
                        }
                    ) {
                        Icon(
                            painter = if (isTodaySectionExpanded) painterResource(id = id.habitask.ui.R.drawable.ic_drop_down_24)
                            else painterResource(id = id.habitask.ui.R.drawable.ic_drop_up_24),
                            contentDescription = null
                        )
                    }
                }

                if (isTodaySectionExpanded) {
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }

                AnimatedVisibility(
                    visible = isTodaySectionExpanded,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    LazyColumn {
                        items(viewState.tasks) { task ->
                            TaskListItem(taskName = task.name,
                                checked = task.checked,
                                onCheckedTask = { checked ->
                                    viewModel.onCheck(task.id, checked)
                                })
                        }
                    }
                }
            }
        }
    }
}