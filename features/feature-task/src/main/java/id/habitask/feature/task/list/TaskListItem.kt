package id.habitask.feature.task.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskListItem(
    taskName: String,
    checked: Boolean,
    onCheckedTask: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CircleShape,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 4.dp)
    ) {
        Box {
            if (checked) {
                Divider(
                    Modifier
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center),
                    thickness = 2.dp
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        onCheckedTask(it)
                    },
                    colors = if (checked) CheckboxDefaults.colors(checkedColor = Color.LightGray) else CheckboxDefaults.colors()
                )
                Text(
                    text = taskName,
                    color = if (checked) Color.LightGray else Color.Unspecified
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskListItem() {
    TaskListItem(taskName = "Wash Car", checked = false, onCheckedTask = {})
}