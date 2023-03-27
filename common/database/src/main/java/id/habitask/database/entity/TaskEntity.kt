package id.habitask.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_entity")
data class TaskEntity(
    @PrimaryKey(true) val id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category_id") val categoryId: Long
)