package id.habitask.data.category.helper

import android.content.Context
import id.habitask.data.category.R
import id.habitask.data.category.model.Category
import javax.inject.Inject

class CategoryHelperImpl @Inject constructor(private val context: Context) : CategoryHelper {

    override fun getDefaultCategories(): List<Category> {
        return listOf(
            Category(
                name = context.getString(R.string.category_name_all),
                position = 1,
                visible = true,
                deletable = false
            ), Category(
                name = context.getString(R.string.category_name_personal),
                position = 2,
                visible = true,
                deletable = false
            ), Category(
                name = context.getString(R.string.category_name_work),
                position = 3,
                visible = true,
                deletable = false
            ), Category(
                name = context.getString(R.string.category_name_others),
                position = 4,
                visible = true,
                deletable = false
            )
        )
    }

}