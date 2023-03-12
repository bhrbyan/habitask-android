package id.habitask.ui

import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Toolbar(
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = title))
        },
        modifier = modifier
    )
}

@Composable
fun ToolbarNavigation(
    @StringRes title: Int,
    navigationIcon: ImageVector,
    onClickNavigationIcon: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = title))
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onClickNavigationIcon()
                }
            ) {
                Icon(imageVector = navigationIcon, contentDescription = null)
            }
        },
        modifier = modifier,
    )
}

@Preview
@Composable
fun PreviewToolbar() {
    Toolbar(title = androidx.compose.ui.R.string.close_drawer)
}

@Preview
@Composable
fun PreviewToolbarNavigation() {
    ToolbarNavigation(
        title = androidx.compose.ui.R.string.close_drawer,
        navigationIcon = Icons.Default.ArrowBack,
        onClickNavigationIcon = {}
    )
}