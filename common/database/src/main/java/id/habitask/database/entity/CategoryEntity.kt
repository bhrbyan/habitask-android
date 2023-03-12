package id.habitask.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_entity")
data class CategoryEntity(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "hex_color") val hexColor: String,
    @ColumnInfo(name = "position") val position: Int,
    @ColumnInfo(name = "visible") val visible: Boolean,
    @ColumnInfo(name = "deletable") val deletable: Boolean
) {
    @PrimaryKey(true)
    var id: Long = 0
}