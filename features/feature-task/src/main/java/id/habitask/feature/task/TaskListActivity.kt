package id.habitask.feature.task

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import id.habitask.ui.Toolbar

@Composable
fun TaskList(
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Toolbar(title = title, modifier)
    }
}