package com.w1mayank.delta.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeltaBottomBar(modifier: Modifier = Modifier) {
    // The translucent Liquid Glass color
    val liquidGlass = Color.White.copy(alpha = 0.7f)
    val iconColor = Color(0xFF1A1A1A)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Back Button (Circle)
        Box(
            modifier = Modifier
                .size(48.dp)
                .shadow(8.dp, CircleShape, spotColor = Color.Black.copy(alpha = 0.1f))
                .clip(CircleShape)
                .background(liquidGlass)
                .bounceClick { /* TODO: Go Back */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Rounded.ChevronLeft, contentDescription = "Back", tint = iconColor)
        }

        // Search Bar (Squircle Pill)
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
                .height(48.dp)
                .shadow(8.dp, RoundedCornerShape(24.dp), spotColor = Color.Black.copy(alpha = 0.1f))
                .clip(RoundedCornerShape(24.dp))
                .background(liquidGlass)
                .bounceClick { /* TODO: Open Keyboard */ }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                Icon(Icons.Rounded.Search, contentDescription = "Search", tint = iconColor, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Search or enter website",
                    color = iconColor.copy(alpha = 0.6f),
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Icon(Icons.Rounded.Mic, contentDescription = "Mic", tint = iconColor, modifier = Modifier.size(20.dp))
        }

        // Menu Button (Circle)
        Box(
            modifier = Modifier
                .size(48.dp)
                .shadow(8.dp, CircleShape, spotColor = Color.Black.copy(alpha = 0.1f))
                .clip(CircleShape)
                .background(liquidGlass)
                .bounceClick { /* TODO: Open Menu */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Rounded.MoreHoriz, contentDescription = "Menu", tint = iconColor)
        }
    }
}
