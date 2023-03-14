package id.habitask.feature.category.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import id.habitask.feature.category.R
import id.habitask.ui.ToolbarNavigation
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CategoryListScreen(
    onClickNavigationIcon: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CategoryListViewModel = viewModel()
) {
    val viewState = viewModel.viewState.collectAsState()

    Column(modifier) {
        ToolbarNavigation(
            title = R.string.category_toolbar,
            navigationIcon = Icons.Default.ArrowBack,
            onClickNavigationIcon = { onClickNavigationIcon() }
        )
        CategoryList(viewState.value.categories)
    }
}