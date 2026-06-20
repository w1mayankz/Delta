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

        // --- THE CRASH CATCHER ENGINE ---
        val prefs = getSharedPreferences("crash_prefs", android.content.Context.MODE_PRIVATE)
        val lastCrash = prefs.getString("last_crash", null)

        if (lastCrash != null) {
            // Wipe the memory so the app can try to run normally next time
            prefs.edit().remove("last_crash").apply()

            // Build a raw, unbreakable Android text view to display the error
            val textView = TextView(this).apply {
                text = "DELTA CRASH LOG:\n\n$lastCrash"
                setTextColor(android.graphics.Color.RED)
                textSize = 13f
                setPadding(40, 120, 40, 40)
            }
            val scrollView = ScrollView(this).apply {
                addView(textView)
            }
            setContentView(scrollView)
            return // Stop the app from trying to load the UI
        }

        // Trap any future crashes instantly
        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            prefs.edit().putString("last_crash", throwable.stackTraceToString()).commit()
            kotlin.system.exitProcess(1) // Force close the app cleanly
        }
        // ---------------------------------

        // Normal App Launch
        setContent {
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
