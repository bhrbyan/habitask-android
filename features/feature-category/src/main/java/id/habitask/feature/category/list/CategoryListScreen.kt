package id.habitask.feature.category.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.habitask.feature.category.R
import id.habitask.ui.ToolbarNavigation

@Composable
fun CategoryListScreen(
    onClickNavigationIcon: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        ToolbarNavigation(
            title = R.string.category_toolbar,
            navigationIcon = Icons.Default.ArrowBack,
            onClickNavigationIcon = { onClickNavigationIcon() }
        )
    }
}