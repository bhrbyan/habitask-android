package id.habitask.feature.category.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.habitask.data.category.model.Category

@Composable
fun CategoryList(
    categories: List<Category>,
    onUpdateVisibility: (category: Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(categories) { category ->
            CategoryListItem(
                category = category,
                onUpdateVisibility = { selectedCategory ->
                    onUpdateVisibility(selectedCategory)
                }
            )
            Divider(
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryList() {
    CategoryList(
        categories = listOf(
            Category("All", "", 0, true, false),
            Category("Personal", "", 1, true, false),
            Category("Work", "", 2, true, false),
            Category("Others", "", 3, true, false),
        ),
        onUpdateVisibility = {}
    )
}