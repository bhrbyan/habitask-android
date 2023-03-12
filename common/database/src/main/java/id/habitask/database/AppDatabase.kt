package id.habitask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.habitask.database.dao.CategoryDao
import id.habitask.database.entity.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    companion object {
        private const val DATABASE_NAME: String = "habitask.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context, AppDatabase::class.java, DATABASE_NAME
                    )
                        .build()
                        .also { INSTANCE = it }
                }

                return instance
            }
        }
    }

}