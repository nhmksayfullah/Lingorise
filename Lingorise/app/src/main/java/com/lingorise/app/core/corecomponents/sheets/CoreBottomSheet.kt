package com.lingorise.app.core.corecomponents.sheets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CoreBottomSheetScreen(
    sheetContent: @Composable (ModalBottomSheetState) -> Unit,
    screenContent: @Composable (ModalBottomSheetState) -> Unit
) {

    var skipHalfExpanded by remember {
        mutableStateOf(false)
    }
    val state = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = skipHalfExpanded
    )
//    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = {
            sheetContent(state)
        }
    ) {
        screenContent(state)
    }

}

@Preview
@Composable
fun CoreBottomSheetPreview() {

}