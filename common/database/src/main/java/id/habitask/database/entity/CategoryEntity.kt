package id.habitask.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_entity")
data class CategoryEntity(
    @PrimaryKey(true) var id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "position") val position: Int,
    @ColumnInfo(name = "visible") val visible: Boolean,
    @ColumnInfo(name = "deletable") val deletable: Boolean
)
