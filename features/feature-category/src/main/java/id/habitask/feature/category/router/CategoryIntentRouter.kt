package id.habitask.feature.category.router

import android.content.Context
import android.content.Intent

interface CategoryIntentRouter {
    fun getIntentCategoryList(context: Context): Intent
}