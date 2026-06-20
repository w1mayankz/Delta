package com.w1mayank.delta.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import compose.icons.FeatherIcons
import compose.icons.feathericons.ChevronLeft
import compose.icons.feathericons.Mic
import compose.icons.feathericons.MoreHorizontal
import compose.icons.feathericons.Search
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterials
import dev.chrisbanes.haze.materials.HazeMaterials
import com.w1mayank.delta.ui.theme.InterFont

@OptIn(ExperimentalHazeMaterials::class)
@Composable
fun DeltaBottomBar(hazeState: HazeState, modifier: Modifier = Modifier) {
    val iconColor = Color(0xFF1A1A1A)
    // The exact Apple math for thick refraction and vibrancy
    val glassStyle = HazeMaterials.thick() 

    Row(
        modifier = modifier
            .fillMaxWidth()
            // Moved the entire bar up to match your screenshot
            .padding(horizontal = 16.dp, bottom = 44.dp, top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Back Circle
        Box(
            modifier = Modifier
                .size(48.dp)
                .shadow(8.dp, CircleShape, spotColor = Color.Black.copy(alpha = 0.1f))
                .bounceClick { } // Squish first
                .clip(CircleShape) // Shape second
                .hazeChild(state = hazeState, style = glassStyle), // Glass third
            contentAlignment = Alignment.Center
        ) {
            Icon(FeatherIcons.ChevronLeft, contentDescription = "Back", tint = iconColor)
        }

        // Search Squircle
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 18.dp) // Compresses the squircle to give circles breathing room
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
                Icon(FeatherIcons.Search, contentDescription = "Search", tint = iconColor, modifier = Modifier.size(18.dp))
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
            Icon(FeatherIcons.Mic, contentDescription = "Mic", tint = iconColor, modifier = Modifier.size(18.dp))
        }

        // Menu Circle
        Box(
            modifier = Modifier
                .size(48.dp)
                .shadow(8.dp, CircleShape, spotColor = Color.Black.copy(alpha = 0.1f))
                .bounceClick { }
                .clip(CircleShape)
                .hazeChild(state = hazeState, style = glassStyle),
            contentAlignment = Alignment.Center
        ) {
            Icon(FeatherIcons.MoreHorizontal, contentDescription = "Menu", tint = iconColor)
        }
    }
}
