package com.w1mayank.delta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.w1mayank.delta.ui.components.DeltaBottomBar
import com.w1mayank.delta.ui.screens.StartPageScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Tells Android to draw behind the system navigation/status bars for that edge-to-edge iOS look
        enableEdgeToEdge()
        
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                
                // The underlying scrollable webpage / Start Page
                StartPageScreen()
                
                // The Liquid Glass navigation bar floating on top
                DeltaBottomBar(
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }
}
