package com.lingorise.app.core.corecomponents.texts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun CoreDropDown(
    menuList: List<String>
) {
    
    var expended by remember {
        mutableStateOf(false)
    }
    var list = menuList
    var selectedItem by remember {
        mutableStateOf("")
    }
    
    var textFiledSize by remember {
        mutableStateOf(Size.Zero)
    }
    val icon = if(expended) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {
                selectedItem = it
            },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFiledSize = coordinates.size.toSize()
                },
            placeholder = { Text(text = "Select Item")},
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "expanding icon",
                    modifier = Modifier
                        .clickable {
                            expended = !expended
                        }
                )
            }
        )

        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textFiledSize.width.toDp()})
        ) {
            list.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                    selectedItem = label
                    expended = false
                }
                ) {
                    Text(text = label)
                }
            }
        }
        
    }
    
}

@Preview
@Composable
fun CoreDropDownPreview() {
    CoreDropDown(menuList = listOf("Option 1", "Option 2", "Option 3"))
}