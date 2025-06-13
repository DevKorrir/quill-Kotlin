package dev.korryr.notecraft.ui.components.splash.presentation

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import kotlin.math.cos
import kotlin.math.sin

fun DrawScope.drawStar(
    center: Offset,
    size: Float,
    rotation: Float,
    color: Color
) {
    rotate(rotation, center) {
        val path = Path()
        val outerRadius = size
        val innerRadius = size * 0.4f
        
        for (i in 0 until 10) {
            val angle = (i * 36 - 90) * Math.PI / 180
            val radius = if (i % 2 == 0) outerRadius else innerRadius
            val x = center.x + (cos(angle) * radius).toFloat()
            val y = center.y + (sin(angle) * radius).toFloat()
            
            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        path.close()
        
        drawPath(
            path = path,
            color = color
        )
    }
}