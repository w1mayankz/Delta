package com.w1mayank.delta.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.HazeMaterials
import dev.chrisbanes.haze.ExperimentalHazeApi

import com.w1mayank.delta.ui.theme.InterFont

@OptIn(ExperimentalHazeApi::class)
@Composable
fun DeltaBottomBar(hazeState: HazeState, modifier: Modifier = Modifier) {
    val iconColor = Color(0xFF1A1A1A)
    val glassStyle = HazeMaterials.thick() 

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 44.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .shadow(8.dp, CircleShape, spotColor = Color.Black.copy(alpha = 0.1f))
                .bounceClick { } 
                .clip(CircleShape) 
                .hazeChild(state = hazeState, style = glassStyle), 
            contentAlignment = Alignment.Center
        ) {
            CupertinoIcon(hexCode = "\uF3D2", contentDescription = "Back", tint = iconColor)
        }

        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 18.dp) 
                .height(48.dp)
                .shadow(8.dp, RoundedCornerShape(24.dp), spotColor = Color.Black.copy(alpha = 0.1f))
                .bounceClick { } 
                .clip(RoundedCornerShape(24.dp))
                .hazeChild(state = hazeState, style = glassStyle)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                CupertinoIcon(hexCode = "\uF4A5", contentDescription = "Search", tint = iconColor, size = 20.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Search or enter website",
                    fontFamily = InterFont,
                    color = iconColor.copy(alpha = 0.6f),
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            CupertinoIcon(hexCode = "\uF3B0", contentDescription = "Mic", tint = iconColor, size = 20.sp)
        }

        Box(
            modifier = Modifier
                .size(48.dp)
                .shadow(8.dp, CircleShape, spotColor = Color.Black.copy(alpha = 0.1f))
                .bounceClick { }
                .clip(CircleShape)
                .hazeChild(state = hazeState, style = glassStyle),
            contentAlignment = Alignment.Center
        ) {
            CupertinoIcon(hexCode = "\uF46A", contentDescription = "Menu", tint = iconColor)
        }
    }
}
