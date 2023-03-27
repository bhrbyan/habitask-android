package id.habitask.feature.task.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskListItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = CircleShape
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    onCheckedChange(it)
                }
            )
            Text(text = taskName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskListItem() {
    TaskListItem(taskName = "Wash Car", checked = false, onCheckedChange = {})
}