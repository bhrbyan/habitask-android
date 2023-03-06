package id.habitask.feature.category

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoryTabList(
    categories: List<String>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier.padding(horizontal = 4.dp)) {
        items(categories) { name ->
            CategoryTabItem(
                name = name,
                modifier = modifier.padding(horizontal = 4.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCategoryTabList() {
    CategoryTabList(
        categories = listOf("All", "Personal", "Work", "Others")
    )
}