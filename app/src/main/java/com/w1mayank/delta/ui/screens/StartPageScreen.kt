package com.w1mayank.delta.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Shield
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.w1mayank.delta.ui.components.bounceClick

@Composable
fun StartPageScreen() {
    val liquidGlass = Color.White.copy(alpha = 0.65f)
    val textColor = Color(0xFF1A1A1A)
    
    // Background color matching the screenshot
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFE8AAB0))) {
        
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 60.dp, bottom = 120.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // 1. Favorites Section
            item {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.Person, contentDescription = null, tint = textColor)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Favorites", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = textColor)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        val letters = listOf("K", "D", "C", "I")
                        val titles = listOf("Kid's Tie-Dye", "Dyed Wicker", "Colorful Homes", "India Trip")
                        for (i in 0..3) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(75.dp)) {
                                Box(
                                    modifier = Modifier.size(70.dp).clip(RoundedCornerShape(16.dp)).background(liquidGlass).bounceClick { },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(letters[i], fontSize = 32.sp, fontWeight = FontWeight.Light, color = Color.White)
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(titles[i], fontSize = 11.sp, color = textColor, maxLines = 2, overflow = TextOverflow.Ellipsis, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                            }
                        }
                    }
                }
            }

            // 2. Privacy Report
            item {
                Column {
                    Text("Privacy Report", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = textColor)
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(liquidGlass).padding(16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Rounded.Shield, contentDescription = null, tint = textColor, modifier = Modifier.size(32.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("135", fontSize = 24.sp, fontWeight = FontWeight.Medium, color = textColor)
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                "No trackers have been banned recently.",
                                fontSize = 14.sp,
                                color = textColor.copy(alpha = 0.8f),
                                lineHeight = 18.sp
                            )
                        }
                    }
                }
            }

            // 3. Reading List
            item {
                Column {
                    Text("Reading List", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = textColor)
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        ArticleCard("P", "Physicists Reveal a Quantum Geometry...", "quantamagazine.org", liquidGlass, textColor)
                        ArticleCard("I", "India Trip - Group Travel | Atlas...", "atlasobscura.com", liquidGlass, textColor)
                    }
                }
            }

            // 4. Edit Button Pill
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .background(Color(0xFF333333)) // Dark gray
                            .bounceClick { /* TODO: Open Customize Menu */ }
                            .padding(horizontal = 24.dp, vertical = 10.dp)
                    ) {
                        Text("Edit", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}

// Reusable component for the articles
@Composable
fun ArticleCard(letter: String, title: String, domain: String, bgColor: Color, textColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)).background(bgColor).bounceClick { }.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(60.dp).clip(RoundedCornerShape(12.dp)).background(Color.White.copy(alpha = 0.4f)),
            contentAlignment = Alignment.Center
        ) {
            Text(letter, fontSize = 28.sp, fontWeight = FontWeight.Light, color = Color.White)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontSize = 15.sp, fontWeight = FontWeight.Medium, color = textColor, maxLines = 2, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(4.dp))
            Text(domain, fontSize = 12.sp, color = textColor.copy(alpha = 0.6f), maxLines = 1)
        }
    }
}
