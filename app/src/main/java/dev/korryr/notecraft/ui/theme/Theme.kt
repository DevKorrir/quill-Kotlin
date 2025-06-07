package dev.korryr.notecraft.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// DARK MODE COLOR SCHEME
private val DarkColorScheme = darkColorScheme(
    // Primary brand colors
    primary = camel02,                    // Lighter camel for better contrast
    onPrimary = navy05,                   // Very dark navy text on camel
    primaryContainer = camel05,           // Deep camel for containers
    onPrimaryContainer = camel04,         // Light camel text

    // Secondary colors
    secondary = Color(115, 135, 175),     // Lighter navy for better visibility
    onSecondary = navy05,                 // Very dark navy text
    secondaryContainer = navy02,          // Medium navy for containers
    onSecondaryContainer = Color(200, 210, 230), // Light blue-gray text

    // Tertiary accent
    tertiary = burgundy02,                // Lighter burgundy for dark mode
    onTertiary = pureWhite,              // White text on burgundy
    tertiaryContainer = burgundy05,       // Deep burgundy for containers
    onTertiaryContainer = burgundy04,     // Soft burgundy text

    // Background colors
    background = navy05,                  // Very dark navy background
    onBackground = darkTextPrimary,       // Light text on dark background
    surface = navy03,                     // Darker navy for cards
    onSurface = darkTextPrimary,          // Light text on dark cards

    // Surface variants
    surfaceVariant = charcoal03,          // Dark charcoal variant surface
    onSurfaceVariant = darkTextSecondary, // Secondary light text
    surfaceTint = camel02,                // Lighter camel tint

    // Outline colors
    outline = charcoal02,                 // Lighter charcoal for borders
    outlineVariant = charcoal03,          // Darker charcoal for subtle borders

    // Utility colors
    error = Color(220, 85, 100),          // Lighter red for dark mode
    onError = pureWhite,
    errorContainer = Color(90, 20, 30),
    onErrorContainer = Color(255, 200, 210),

    // Inverse colors
    inverseSurface = softWhite,
    //onInverseSurface = navy05,
    inversePrimary = camel03
)

// LIGHT MODE COLOR SCHEME
private val LightColorScheme = lightColorScheme(
    // Primary brand colors
    primary = camel01,                    // Main camel for buttons, FAB
    onPrimary = pureWhite,               // White text on camel
    primaryContainer = camel04,           // Very light camel for containers
    onPrimaryContainer = navy03,          // Dark navy text on light camel

    // Secondary colors
    secondary = navy01,                   // Navy for headers, navigation
    onSecondary = pureWhite,             // White text on navy
    secondaryContainer = Color(235, 240, 250), // Light navy tint for containers
    onSecondaryContainer = navy03,        // Dark navy text

    // Tertiary accent
    tertiary = burgundy01,                // Burgundy for important actions
    onTertiary = pureWhite,              // White text on burgundy
    tertiaryContainer = Color(245, 225, 232), // Light burgundy tint
    onTertiaryContainer = burgundy03,     // Dark burgundy text

    // Background colors
    background = softWhite,               // Main background
    onBackground = lightTextPrimary,      // Dark gray text on white
    surface = pureWhite,                  // Card surfaces
    onSurface = lightTextPrimary,         // Dark text on white cards

    // Surface variants
    surfaceVariant = Color(248, 248, 248), // Slightly gray surface
    onSurfaceVariant = lightTextSecondary, // Secondary text
    surfaceTint = camel01,                // Camel tint for elevated surfaces

    // Outline colors
    outline = charcoal04,                 // Light charcoal for borders
    outlineVariant = Color(220, 220, 220), // Very light gray for subtle borders

    // Utility colors
    error = errorRed,
    onError = pureWhite,
    errorContainer = Color(250, 230, 235),
    onErrorContainer = Color(120, 30, 45),

    // Inverse colors (for snackbars, etc.)
    inverseSurface = charcoal01,
    //onInverseSurface = pureWhite,
    inversePrimary = camel02
)

@Composable
fun NoteCraftTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}