package com.w1mayank.delta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.chrisbanes.haze.HazeState
import com.w1mayank.delta.ui.components.DeltaBottomBar
import com.w1mayank.delta.ui.screens.StartPageScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            // FIX: Added the MaterialTheme wrapper so the Bottom Sheet doesn't panic
            MaterialTheme {
                val hazeState = remember { HazeState() }
                
                Box(modifier = Modifier.fillMaxSize()) {
                    StartPageScreen(hazeState = hazeState)
                    
                    DeltaBottomBar(
                        hazeState = hazeState,
                        modifier = Modifier.align(Alignment.BottomCenter)
                    )
                }
            }
        }
    }
}
