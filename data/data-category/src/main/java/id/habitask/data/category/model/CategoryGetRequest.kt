package id.habitask.data.category.model

sealed class CategoryGetRequest {

    object All : CategoryGetRequest()
    object VisibleOnly : CategoryGetRequest()

}
