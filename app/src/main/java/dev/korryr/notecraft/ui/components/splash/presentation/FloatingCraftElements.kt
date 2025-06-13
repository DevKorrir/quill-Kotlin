package dev.korryr.notecraft.ui.components.splash.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun FloatingCraftElements(
    floatOffset: Float,
    rotation: Float
) {
    // Floating stars and sparkles around the logo
    val elements = listOf(
        Triple(0.2f, 0.3f, 12f),   // x, y, size
        Triple(0.8f, 0.2f, 8f),
        Triple(0.1f, 0.7f, 10f),
        Triple(0.9f, 0.8f, 6f),
        Triple(0.5f, 0.1f, 14f),
        Triple(0.3f, 0.9f, 9f)
    )
    
    Canvas(modifier = Modifier.fillMaxSize()) {
        elements.forEachIndexed { index, (x, y, starSize) ->
            val offsetMultiplier = if (index % 2 == 0) 1f else -1f
            val currentOffset = floatOffset * offsetMultiplier
            
            drawStar(
                center = Offset(
                    size.width * x + currentOffset,
                    size.height * y + currentOffset * 0.5f
                ),
                size = starSize,
                rotation = rotation + (index * 45f),
                color = Color.White.copy(alpha = 0.6f)
            )
        }
    }
}