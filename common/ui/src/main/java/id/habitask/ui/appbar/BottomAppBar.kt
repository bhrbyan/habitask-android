package id.habitask.ui.appbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBarWithFloatingActionButton(
    onClickFloatingActionButton: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(50.dp)
                )
            ) {}
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onClickFloatingActionButton() }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}