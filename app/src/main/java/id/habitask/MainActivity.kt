package id.habitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import dagger.hilt.android.AndroidEntryPoint
import id.habitask.feature.category.ui.tab.CategoryTabScreen
import id.habitask.feature.task.bottomsheet.TaskBottomSheetFormScreen
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
                var taskValue by rememberSaveable {
                    mutableStateOf("")
                }

                BottomSheet(
                    screenContent = {
                        Column {
                            TopAppBar(
                                title = R.string.app_name
                            )
                            CategoryTabScreen()
                        }
                    },
                    sheetContent = {
                        TaskBottomSheetFormScreen(
                            taskValue = taskValue,
                            onChangeTaskValue = {
                                taskValue = it
                            }
                        )
                    }
                )
            }
        }
    }
}