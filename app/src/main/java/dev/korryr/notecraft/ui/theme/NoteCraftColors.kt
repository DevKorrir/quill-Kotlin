package dev.korryr.notecraft.ui.theme

import androidx.compose.ui.graphics.Color

object NoteCraftColors {
    // Note categories (can be used for tags/folders)
    val categoryWork = Color(88, 140, 195)      // Professional blue
    val categoryPersonal = Color(155, 120, 200)  // Soft purple
    val categoryIdeas = Color(255, 180, 90)      // Creative orange
    val categoryTasks = Color(100, 175, 120)     // Productive green
    val categoryImportant = burgundy01           // Using burgundy for important
    
    // Status colors
    val pinnedNote = camel01                     // Camel for pinned notes
    val archivedNote = charcoal04                // Light charcoal for archived
    val recentEdit = Color(85, 170, 200)         // Fresh blue for recently edited
    
    // Gradient colors for splash/onboarding
    val gradientStart = camel01
    val gradientEnd = navy01
    
    // Floating Action Button gradient
    val fabGradientStart = burgundy01
    val fabGradientEnd = burgundy02
    
    // Selection colors
    val selectionHighlight = Color(camel01.red, camel01.green, camel01.blue, 0.2f) // 20% opacity camel
    val textSelection = Color(camel02.red, camel02.green, camel02.blue, 0.3f)      // 30% opacity light camel
}

// Extension functions for color utilities
fun Color.withAlpha(alpha: Float): Color = Color(red, green, blue, alpha)

// Preview colors for design system documentation
val previewColors = listOf(
    "Camel Primary" to camel01,
    "Navy Secondary" to navy01,
    "Burgundy Tertiary" to burgundy01,
    "Charcoal Neutral" to charcoal01,
    "Success Green" to successGreen,
    "Error Red" to errorRed,
    "Warning Amber" to warningAmber
)