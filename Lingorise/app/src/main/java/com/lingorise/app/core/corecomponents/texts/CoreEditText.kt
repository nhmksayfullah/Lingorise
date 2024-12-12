package com.lingorise.app.core.corecomponents.texts

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lingorise.app.core.constants.defaultEditTextModifier
import com.lingorise.app.core.constants.defaultPlaceHolder
import com.lingorise.app.ui.theme.LingoriseTheme
import kotlinx.coroutines.launch


//@Composable
//fun CoreEditText(
//    placeHolder: String = defaultPlaceHolder,
//    modifier: Modifier = Modifier.padding(16.dp),
//    enabled: Boolean = true,
//    readOnly: Boolean = false,
//    textStyle: TextStyle = TextStyle.Default,
//    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
//    keyboardActions: KeyboardActions = KeyboardActions.Default,
//    singleLine: Boolean = true,
//    maxLines: Int = 1,
//    visualTransformation: VisualTransformation = VisualTransformation.None,
//    onTextLayout: (TextLayoutResult) -> Unit = {},
//    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
//    cursorBrush: Brush = SolidColor(Color.Black),
//    isCustomDecoration: Boolean = false,
//    decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
//        @Composable { innerTextField -> innerTextField() },
//    onTextInputting: (String) -> Unit
//) {
//
//    var editableTextState by remember {
//        mutableStateOf("")
//    }
//
//    BasicTextField(
//        value = editableTextState,
//        onValueChange = {
//            editableTextState = it
//            onTextInputting(it)
//        },
//        modifier = modifier,
//        enabled = enabled,
//        readOnly = readOnly,
//        textStyle = textStyle,
//        keyboardOptions = keyboardOptions,
//        keyboardActions = keyboardActions,
//        singleLine = singleLine,
//        maxLines = maxLines,
//        visualTransformation = visualTransformation,
//        onTextLayout = onTextLayout,
//        interactionSource = interactionSource,
//        cursorBrush = cursorBrush,
//        decorationBox = { innerTextField ->
//
//            if (isCustomDecoration) {
//                decorationBox(innerTextField)
//
//            } else {
//
//                Row(
//                    modifier = defaultEditTextModifier,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Box {
//                        if (editableTextState == "") {
//                            Text(text = placeHolder)
//                        }
//                        innerTextField()
//                    }
//                }
//            }
//        }
//    )
//
//}


@Composable
fun CoreEditText(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    defaultValue: String = "",
    onValueChange: (String) -> Unit
) {
    var editableTextState by remember {

       mutableStateOf(defaultValue)
    }
    OutlinedTextField(
        value = editableTextState,
        onValueChange = {
            editableTextState = it
            onValueChange(editableTextState)
        },
        placeholder = placeholder,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoreEditTextPreview() {
    LingoriseTheme {
        val snackbarHostState = remember{ SnackbarHostState() }
        val scope = rememberCoroutineScope()

        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        ) {
            Column(Modifier.padding(it)) {
                CoreEditText {
                    scope.launch {
                        snackbarHostState.showSnackbar("Hello $it")
                    }
                }
            }
        }



    }
}
