package id.habitask.feature.task

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.habitask.feature.category.CategoryTabList
import id.habitask.ui.Toolbar
import id.habitask.ui.R

@Composable
fun TaskList(modifier: Modifier = Modifier) {
    Column(modifier) {
        Toolbar(title = R.string.app_name, modifier)
        CategoryTabList(
            categories = listOf(
                "All",
                "Personal",
                "Work",
                "Others"
            )
        )
    }
}

@Preview(showBackground = true, heightDp = 900)
@Composable
fun PreviewTaskList() {
    TaskList()
}