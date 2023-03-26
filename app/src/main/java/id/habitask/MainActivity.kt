package id.habitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import id.habitask.feature.category.router.CategoryIntentRouter
import id.habitask.feature.task.TaskListScreen
import id.habitask.ui.appbar.BottomAppBarWithFloatingActionButton
import id.habitask.ui.theme.HabitaskTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var categoryIntentRouter: CategoryIntentRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitaskTheme {
                BottomAppBarWithFloatingActionButton(
                    onClickFloatingActionButton = {
                        // Open Bottom Sheet
                    },
                    content = {
                        TaskListScreen()
                    }
                )
            }
        }
    }
}