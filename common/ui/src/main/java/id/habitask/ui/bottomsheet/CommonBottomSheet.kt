package id.habitask.ui.bottomsheet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    screenContent: @Composable () -> Unit,
    sheetContent: @Composable () -> Unit
) {

    BottomSheetScaffold(
        sheetContent = {
            sheetContent()
        },
        sheetPeekHeight = 80.dp,
        modifier = modifier,
        sheetElevation = BottomSheetScaffoldDefaults.SheetElevation,
        sheetShape = CircleShape.copy(bottomEnd = CornerSize(0.dp), bottomStart = CornerSize(0.dp)),
        sheetBackgroundColor = Color.Yellow,
        sheetGesturesEnabled = false
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