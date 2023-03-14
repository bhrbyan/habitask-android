package id.habitask.feature.category.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.habitask.data.category.model.Category
import id.habitask.ui.R

@Composable
fun CategoryListItem(
    category: Category,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = Icons.Default.Menu,
            contentDescription = null
        )
        Text(
            text = category.name,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_visibility_24),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryListItem() {
    CategoryListItem(category = Category("All", "", 0, true))
}