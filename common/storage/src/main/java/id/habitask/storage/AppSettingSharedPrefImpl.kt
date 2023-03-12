package id.habitask.storage

import android.content.Context

class AppSettingSharedPrefImpl(context: Context) : AppSettingSharedPref {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override var firstTimeUser: Boolean
        get() = sharedPreferences.getBoolean(KEY_FIRST_TIME_USER, true)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_FIRST_TIME_USER, value).apply()
        }

    companion object {
        private const val SHARED_PREFERENCES_NAME: String = "id.habitask.app.setting"
        private const val KEY_FIRST_TIME_USER: String = "first_time_user"
    }
}