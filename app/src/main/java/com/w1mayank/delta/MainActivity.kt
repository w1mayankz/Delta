package com.w1mayank.delta

import android.os.Bundle
import android.widget.ScrollView
import android.widget.TextView
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

        val prefs = getSharedPreferences("crash_prefs", android.content.Context.MODE_PRIVATE)
        val lastCrash = prefs.getString("last_crash", null)

        if (lastCrash != null) {
            prefs.edit().remove("last_crash").apply()
            val textView = TextView(this).apply {
                text = "DELTA CRASH LOG:\n\n$lastCrash"
                setTextColor(android.graphics.Color.RED)
                textSize = 13f
                setPadding(40, 120, 40, 40)
            }
            val scrollView = ScrollView(this).apply { addView(textView) }
            setContentView(scrollView)
            return 
        }

        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            prefs.edit().putString("last_crash", throwable.stackTraceToString()).commit()
            kotlin.system.exitProcess(1) 
        }

        setContent {
            MaterialTheme {
                // --- THE DUAL GLASS ENGINES ---
                val backgroundHazeState = remember { HazeState() } // Blurs the wallpaper
                val contentHazeState = remember { HazeState() }    // Blurs the scrolling content
                
                Box(modifier = Modifier.fillMaxSize()) {
                    
                    // Give the Start Page access to both engines
                    StartPageScreen(
                        backgroundHazeState = backgroundHazeState,
                        contentHazeState = contentHazeState
                    )
                    
                    // The Bottom Bar only needs the Content Engine
                    DeltaBottomBar(
                        hazeState = contentHazeState,
                        modifier = Modifier.align(Alignment.BottomCenter)
                    )
                }
            }
        }
    }
}
