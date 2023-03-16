package id.habitask.ui.state

sealed class ViewState {

    abstract class Feature : ViewState()

    data class Error(val message: String) : ViewState()

    sealed class Loading {
        object Show : ViewState()
        object Hide : ViewState()
    }

}
