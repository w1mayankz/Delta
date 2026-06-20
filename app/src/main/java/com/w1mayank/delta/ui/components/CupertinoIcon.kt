package com.w1mayank.delta.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.w1mayank.delta.R

// FIX: Locked to Normal weight so Android can never throw it away
val CupertinoFont = FontFamily(Font(R.font.cupertino_icons, FontWeight.Normal))

@Composable
fun CupertinoIcon(
    hexCode: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFF1A1A1A),
    size: TextUnit = 24.sp
) {
    Text(
        text = hexCode,
        fontFamily = CupertinoFont,
        fontWeight = FontWeight.Normal, // CRITICAL: Forces Compose to stay on the Apple font
        color = tint,
        fontSize = size,
        modifier = modifier
    )
}
