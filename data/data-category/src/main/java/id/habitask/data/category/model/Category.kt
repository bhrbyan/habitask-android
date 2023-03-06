package id.habitask.data.category.model

data class Category(
    val id: Long,
    val name: String,
    val hexColor: String,
    val position: Int,
    val visible: Boolean,
    val deletable: Boolean = true
)
