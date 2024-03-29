package id.habitask.feature.category.tab

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.habitask.data.category.model.Category

@Composable
fun CategoryTabList(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
        items(categories) { category ->
            CategoryTabItem(
                name = category.name,
                modifier = modifier.padding(horizontal = 4.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCategoryTabList() {
    CategoryTabList(
        categories = listOf(
            Category("All", 1, visible = true, deletable = false),
            Category("Personal", 1, true),
            Category("Work", 1, true),
            Category("Others", 1, true)
        )
    )
}