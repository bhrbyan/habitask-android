package id.habitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import id.habitask.feature.category.router.CategoryIntentRouter
import id.habitask.feature.task.TaskListScreen
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
                Scaffold(
                    bottomBar = {
                        BottomAppBar(
                            cutoutShape = MaterialTheme.shapes.small.copy(
                                CornerSize(50.dp)
                            )
                        ) {}
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null
                            )
                        }
                    },
                    isFloatingActionButtonDocked = true,
                    floatingActionButtonPosition = FabPosition.Center
                ) {
                    Surface(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        TaskListScreen()
                    }
                }
            }
        }
    }
}