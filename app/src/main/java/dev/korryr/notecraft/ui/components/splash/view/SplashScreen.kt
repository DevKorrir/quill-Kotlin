package dev.korryr.notecraft.ui.components.splash.view

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.korryr.notecraft.ui.components.splash.presentation.FloatingCraftElements
import dev.korryr.notecraft.ui.components.splash.presentation.LoadingIndicator
import dev.korryr.notecraft.ui.components.splash.presentation.NotebookIcon

@Composable
fun SplashScreen() {
    // Animation states
    val infiniteTransition = rememberInfiniteTransition(label = "splash_animation")
    
    // Logo scale animation
    val logoScale by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "logo_scale"
    )
    
    // Floating animation for decorative elements
    val floatOffset by infiniteTransition.animateFloat(
        initialValue = -10f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "float_offset"
    )
    
    // Rotation animation for craft tools
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )
    
    // Text fade in animation
    val textAlpha by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "text_alpha"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(193, 154, 107), // Camel center
                        Color(25, 42, 86)     // Navy edges
                    ),
                    radius = 800f
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            
            // Decorative floating elements
            Box(
                modifier = Modifier.size(300.dp),
                contentAlignment = Alignment.Center
            ) {
                // Floating craft elements around the logo
                FloatingCraftElements(
                    floatOffset = floatOffset,
                    rotation = rotation
                )
                
                // Main logo area
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Cute notebook icon
                    NotebookIcon(
                        scale = logoScale,
                        rotation = rotation * 0.1f // Subtle rotation
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    // App name with cute styling
                    Text(
                        text = "NoteCraft",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.alpha(textAlpha)
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Craft Your Thoughts",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.White.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.alpha(textAlpha * 0.8f)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(60.dp))
            
            // Loading indicator
            LoadingIndicator()
        }
    }
}