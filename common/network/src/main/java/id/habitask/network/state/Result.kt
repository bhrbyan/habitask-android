package id.habitask.network.state

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failed(val exception: Exception) : Result<Nothing>()
}
