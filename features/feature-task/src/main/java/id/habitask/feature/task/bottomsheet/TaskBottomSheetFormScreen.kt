package id.habitask.feature.task.bottomsheet

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import id.habitask.ui.R

@Composable
fun TaskFormBottomSheet(
    viewModel: TaskBottomSheetFormViewModel = viewModel()
) {
    var taskInputTextValue by rememberSaveable {
        mutableStateOf("")
    }

    val viewState = viewModel.viewState.collectAsState()

    if (viewState.value) {
        taskInputTextValue = ""
        viewModel.resetState()
    }

    Row(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        OutlinedTextField(
            placeholder = {
                Text(text = stringResource(R.string.task_bottom_sheet_placeholder))
            },
            value = taskInputTextValue,
            onValueChange = {
                taskInputTextValue = it
            },
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            shape = CircleShape
        )
        FloatingActionButton(
            backgroundColor = if (taskInputTextValue.isEmpty())
                Color.LightGray
            else
                MaterialTheme.colors.secondary,
            onClick = {
                if (taskInputTextValue.isNotEmpty()) {
                    viewModel.saveTask(taskInputTextValue)
                }
            }
        ) {
            Icon(
                Icons.Rounded.Send,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
    }
}