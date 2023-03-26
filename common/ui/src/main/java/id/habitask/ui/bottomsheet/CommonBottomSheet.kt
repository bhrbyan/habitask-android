package id.habitask.ui.bottomsheet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    screenContent: @Composable () -> Unit,
    sheetContent: @Composable () -> Unit
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            sheetContent()
        },
        sheetPeekHeight = BottomSheetScaffoldDefaults.SheetPeekHeight,
        modifier = modifier,
        sheetElevation = BottomSheetScaffoldDefaults.SheetElevation,
        sheetShape = MaterialTheme.shapes.small,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.apply {
                            if (isCollapsed) expand() else collapse()
                        }
                    }
                }
            ) {
                Text(text = "Add")
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            screenContent()
        }
    }
}