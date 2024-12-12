package com.lingorise.app.core.corecomponents.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lingorise.app.ui.theme.LingoriseSkyBlue

@Composable
fun CoreFilledButton(
    label: String,
    buttonColor: Color = LingoriseSkyBlue,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = RoundedCornerShape(percent = 10),
        onClick = { onClick() }
    ) {
        Text(
            text = label,
            modifier = Modifier
                .padding(4.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoreFilledButtonPreview() {
    CoreFilledButton(label = "Continue", buttonColor = LingoriseSkyBlue) {

    }
}