package id.habitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import id.habitask.feature.task.TaskListScreen
import id.habitask.ui.R
import id.habitask.ui.appbar.TopAppBar
import id.habitask.ui.bottomsheet.BottomSheet
import id.habitask.ui.theme.HabitaskTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitaskTheme {
                var text by rememberSaveable {
                    mutableStateOf("")
                }

                BottomSheet(
                    screenContent = {
                        Column {
                            TopAppBar(title = R.string.app_name)
                            TaskListScreen()
                        }
                    },
                    sheetContent = {
                        Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)) {
                            OutlinedTextField(
                                placeholder = {
                                    Text(text = stringResource(R.string.task_bottom_sheet_placeholder))
                                },
                                value = text,
                                onValueChange = {
                                    text = it
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 16.dp),
                                shape = CircleShape
                            )
                            FloatingActionButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    Icons.Default.Send,
                                    contentDescription = null,
                                    modifier = Modifier.size(ButtonDefaults.IconSize)
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}