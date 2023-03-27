package id.habitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import dagger.hilt.android.AndroidEntryPoint
import id.habitask.feature.category.ui.tab.CategoryTab
import id.habitask.feature.task.bottomsheet.TaskFormBottomSheet
import id.habitask.feature.task.list.TaskList
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
                BottomSheet(
                    screenContent = {
                        Column {
                            TopAppBar(
                                title = R.string.app_name
                            )
                            CategoryTab()
                            TaskList()
                        }
                    },
                    sheetContent = {
                        TaskFormBottomSheet()
                    }
                )
            }
        }
    }
}