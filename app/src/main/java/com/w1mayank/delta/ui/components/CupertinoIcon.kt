package com.w1mayank.delta.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.w1mayank.delta.R

// Maps the .ttf file you just uploaded
val CupertinoFont = FontFamily(Font(R.font.cupertino_icons))

@Composable
fun CupertinoIcon(
    hexCode: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFF1A1A1A),
    size: TextUnit = 24.sp
) {
    // Android draws font-based icons using the pure Text canvas
    Text(
        text = hexCode,
        fontFamily = CupertinoFont,
        color = tint,
        fontSize = size,
        modifier = modifier
    )
}
