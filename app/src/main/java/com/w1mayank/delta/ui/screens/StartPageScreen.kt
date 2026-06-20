package com.w1mayank.delta.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Fixed Haze Imports
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.HazeMaterials
import dev.chrisbanes.haze.ExperimentalHazeApi

import com.w1mayank.delta.ui.components.bounceClick
import com.w1mayank.delta.ui.components.CupertinoIcon
import com.w1mayank.delta.ui.theme.InterFont

// FIX: Removed the missing CustomizeMenu import and updated the OptIn
@OptIn(ExperimentalMaterial3Api::class, ExperimentalHazeApi::class)
@Composable
fun StartPageScreen(hazeState: HazeState) {
    val textColor = Color(0xFF1A1A1A)
    val bgColor = Color(0xFFE8AAB0) 
    
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showBottomSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize().background(bgColor)) {
        
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .haze(state = hazeState),
            contentPadding = PaddingValues(top = 100.dp, bottom = 180.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Favorites Section
            item {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CupertinoIcon(hexCode = "\uF47D", contentDescription = "Favorites", tint = textColor, size = 24.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Favorites", fontFamily = InterFont, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = textColor)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        val letters = listOf("K", "D", "C", "I")
                        val titles = listOf("Kid's Tie-Dye", "Dyed Wicker", "Colorful Homes", "India Trip")
                        for (i in 0..3) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(75.dp)) {
                                Box(
                                    modifier = Modifier
                                        .size(70.dp)
                                        .bounceClick { } 
                                        .clip(RoundedCornerShape(16.dp))
                                        .hazeChild(state = hazeState, style = HazeMaterials.thin()),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(letters[i], fontFamily = InterFont, fontSize = 32.sp, fontWeight = FontWeight.Normal, color = Color.White)
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(titles[i], fontFamily = InterFont, fontSize = 11.sp, color = textColor, maxLines = 2, overflow = TextOverflow.Ellipsis, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                            }
                        }
                    }
                }
            }

            // Privacy Report
            item {
                Column {
                    Text("Privacy Report", fontFamily = InterFont, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = textColor)
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .bounceClick { }
                            .clip(RoundedCornerShape(20.dp))
                            .hazeChild(state = hazeState, style = HazeMaterials.thin())
                            .padding(16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            CupertinoIcon(hexCode = "\uF4B2", contentDescription = "Privacy", tint = textColor, size = 24.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("135", fontFamily = InterFont, fontSize = 24.sp, fontWeight = FontWeight.Medium, color = textColor)
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                "In the last seven days, Delta has prevented 135 trackers.",
                                fontFamily = InterFont,
                                fontSize = 14.sp,
                                color = textColor.copy(alpha = 0.8f),
                                lineHeight = 18.sp
                            )
                        }
                    }
                }
            }

            // Reading List
            item {
                Column {
                    Text("Reading List", fontFamily = InterFont, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = textColor)
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        ArticleCard("P", "Physicists Reveal a Quantum Geometry...", "quantamagazine.org", hazeState)
                        ArticleCard("I", "India Trip - Group Travel | Atlas...", "atlasobscura.com", hazeState)
                    }
                }
            }

            // Edit Button
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Box(
                        modifier = Modifier
                            .bounceClick { showBottomSheet = true }
                            .clip(RoundedCornerShape(24.dp))
                            .background(Color(0xFF333333))
                            .padding(horizontal = 24.dp, vertical = 10.dp)
                    ) {
                        Text("Edit", fontFamily = InterFont, color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(Alignment.TopCenter)
                .hazeChild(state = hazeState, style = HazeMaterials.regular())
                .background(Brush.verticalGradient(listOf(bgColor, bgColor.copy(alpha = 0.8f), Color.Transparent)))
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .align(Alignment.BottomCenter)
                .hazeChild(state = hazeState, style = HazeMaterials.regular())
                .background(Brush.verticalGradient(listOf(Color.Transparent, bgColor.copy(alpha = 0.8f), bgColor)))
        )

        // FIX: Temporary placeholder block until we actually build the Customize Menu file
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                containerColor = Color(0xFFF2F2F7),
                dragHandle = null
            ) {
                Box(modifier = Modifier.fillMaxWidth().height(200.dp).padding(24.dp), contentAlignment = Alignment.Center) {
                    Text("Customize Menu (To be built!)", fontFamily = InterFont, color = Color.Black, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@OptIn(ExperimentalHazeApi::class)
@Composable
fun ArticleCard(letter: String, title: String, domain: String, hazeState: HazeState) {
    val textColor = Color(0xFF1A1A1A)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .bounceClick { } 
            .clip(RoundedCornerShape(20.dp))
            .hazeChild(state = hazeState, style = HazeMaterials.thin())
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(60.dp).clip(RoundedCornerShape(12.dp)).background(Color.White.copy(alpha = 0.4f)),
            contentAlignment = Alignment.Center
        ) {
            Text(letter, fontFamily = InterFont, fontSize = 28.sp, fontWeight = FontWeight.Normal, color = Color.White)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontFamily = InterFont, fontSize = 15.sp, fontWeight = FontWeight.Medium, color = textColor, maxLines = 2, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(4.dp))
            Text(domain, fontFamily = InterFont, fontSize = 12.sp, color = textColor.copy(alpha = 0.6f), maxLines = 1)
        }
    }
}
