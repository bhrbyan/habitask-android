package id.habitask.feature.category.router

import android.content.Context
import android.content.Intent
import id.habitask.feature.category.list.CategoryListActivity

internal class CategoryIntentRouterImpl : CategoryIntentRouter {

    override fun getIntentCategoryList(context: Context): Intent {
        return Intent(context, CategoryListActivity::class.java)
    }

}