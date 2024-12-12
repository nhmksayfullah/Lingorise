package com.lingorise.app.core.gamebox.quizer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lingorise.app.core.corecomponents.buttons.SimpleOptionsView
import com.lingorise.app.core.gamebox.quizer.model.Option
import com.lingorise.app.core.gamebox.quizer.model.Quiz
import com.lingorise.app.ui.theme.LingoriseYellow

@Composable
fun SimpleQuizView(
    quiz: Quiz,
    modifier: Modifier = Modifier,
    onSelected: (Option) -> Unit
) {


    Box(
        modifier = modifier
            .wrapContentSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Column {
            Text(
                text = quiz.question,
                style = MaterialTheme.typography.h6.merge(),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(60.dp))

            SimpleOptionsView(options = quiz.options) {
                onSelected(it)
            }
        }

    }
}