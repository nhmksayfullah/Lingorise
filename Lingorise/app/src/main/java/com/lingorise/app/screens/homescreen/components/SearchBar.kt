package com.lingorise.app.screens.homescreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lingorise.app.core.corecomponents.texts.CoreEditText
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import com.lingorise.app.R
import com.lingorise.app.core.constants.defaultButtonOutlineColor
import com.lingorise.app.core.constants.defaultEditTextModifier

@Composable
fun SearchBar(
    placeHolder: String = "Search For a Course",
    icon: Int = R.drawable.icon_filter,
    buttonShape: Shape = MaterialTheme.shapes.small,
    onClickDummy: (Boolean) -> Unit,
    onClick: (Boolean) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box {
            CoreEditText(
                readOnly = true,
                enabled = false,
                placeholder = {
                    Text(text = placeHolder)
                },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(.9f)
                    .padding(end = 16.dp)
                    .clickable {
                        onClickDummy(true)
                    }
            ) {

            }
        }

        IconButton(
            modifier = Modifier
                .size(50.dp)
                .border(BorderStroke(.5.dp, Color.DarkGray), buttonShape)
                ,
            onClick = { onClick(true) }) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Filter Button",
                tint = LingoriseSkyBlue,
                modifier = Modifier.size(20.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar(
        onClickDummy = {

        }
    ) {

    }
}