package dev.korryr.notecraft.ui.components.splash.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun NotebookIcon(
    scale: Float,
    rotation: Float,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .size(120.dp)
            .scale(scale)
            .rotate(rotation)
    ) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val notebookWidth = size.width * 0.7f
        val notebookHeight = size.height * 0.8f
        
        // Notebook shadow
        drawRoundRect(
            color = Color.Black.copy(alpha = 0.3f),
            topLeft = Offset(
                centerX - notebookWidth/2 + 4.dp.toPx(),
                centerY - notebookHeight/2 + 4.dp.toPx()
            ),
            size = androidx.compose.ui.geometry.Size(notebookWidth, notebookHeight),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(8.dp.toPx())
        )
        
        // Main notebook body
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(centerX - notebookWidth/2, centerY - notebookHeight/2),
            size = androidx.compose.ui.geometry.Size(notebookWidth, notebookHeight),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(8.dp.toPx())
        )
        
        // Notebook spiral binding
        val spiralColor = Color(128, 32, 32) // Burgundy
        for (i in 0..6) {
            val y = centerY - notebookHeight/2 + (i * notebookHeight/7) + notebookHeight/14
            drawCircle(
                color = spiralColor,
                radius = 6.dp.toPx(),
                center = Offset(centerX - notebookWidth/2 + 20.dp.toPx(), y)
            )
        }
        
        // Notebook lines
        val lineColor = Color(193, 154, 107).copy(alpha = 0.5f) // Light camel
        for (i in 1..5) {
            val y = centerY - notebookHeight/4 + (i * 12.dp.toPx())
            drawLine(
                color = lineColor,
                start = Offset(centerX - notebookWidth/3, y),
                end = Offset(centerX + notebookWidth/3, y),
                strokeWidth = 1.5.dp.toPx()
            )
        }
        
        // Cute pencil on notebook
        val pencilStart = Offset(centerX + notebookWidth/4, centerY - notebookHeight/4)
        val pencilEnd = Offset(centerX + notebookWidth/3, centerY - notebookHeight/6)
        
        // Pencil body
        drawLine(
            color = Color(255, 215, 0), // Gold pencil
            start = pencilStart,
            end = pencilEnd,
            strokeWidth = 8.dp.toPx(),
            cap = StrokeCap.Round
        )
        
        // Pencil tip
        drawCircle(
            color = Color(139, 106, 67), // Dark camel
            radius = 3.dp.toPx(),
            center = pencilEnd
        )
    }
}