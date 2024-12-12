package com.lingorise.app.core.spotlight.blocks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lingorise.app.R
import com.lingorise.app.core.spotlight.ActionIcon
import com.lingorise.app.domain.model.SpotlightData


@Composable
fun SpotlightButtonsColumn(
    spotlightData: SpotlightData,
    onIconClicked: (ActionIcon) -> Unit
) {
    Icon(
        painter = painterResource(id = R.drawable.icon_love_outlined),
        contentDescription = "icon love",
        modifier = Modifier
            .size(30.dp)
            .clickable {
                onIconClicked(ActionIcon.LIKE)
            },
        tint = Color.White
    )

    IconButton(onClick = { onIconClicked(ActionIcon.SHARE) }) {
        Icon(
            imageVector = Icons.Outlined.Share,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(30.dp)
        )
    }

    IconButton(onClick = { onIconClicked(ActionIcon.MORE_OPTIONS) }) {
        Icon(
            imageVector = Icons.Outlined.MoreVert,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(30.dp)
                .rotate(90f),
        )
    }
}
