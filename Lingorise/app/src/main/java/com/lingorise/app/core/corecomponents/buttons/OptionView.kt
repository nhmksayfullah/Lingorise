package com.lingorise.app.core.corecomponents.buttons

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lingorise.app.core.gamebox.quizer.model.Option
import com.lingorise.app.data.repository.fakedata.fakeQuizData
import com.lingorise.app.ui.theme.LingoriseLightWhite
import com.lingorise.app.ui.theme.LingoriseYellow

@Composable
fun SimpleOptionsView(
    options: List<Option>,
    onSelected: (Option) -> Unit
) {

    val(selectedOption, onOptionSelected) = remember {
        mutableStateOf(-1)
    }
    Column(
        modifier = Modifier
            .selectableGroup()
    ) {
        options.forEach { option ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (option.index == selectedOption),
                        onClick = {
                            onOptionSelected(option.index)
                            onSelected(option)
                        },
                        role = Role.RadioButton
                    )
                    .padding(vertical = 4.dp)
                    .background(
                        color = if(option.index == selectedOption) LingoriseYellow else Color.Transparent,
                        shape = if(option.index == selectedOption) RoundedCornerShape(percent = 10)
                        else RectangleShape

                    )
                    .border(BorderStroke(2.dp, LingoriseLightWhite))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = option.label,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OptionsViewPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SimpleOptionsView(options = fakeQuizData()[0].options) {
            Log.d("selected", it.toString())
        }
    }
}