package dev.korryr.notecraft.application

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.korryr.notecraft.ui.components.home.view.HomePage
import dev.korryr.notecraft.ui.components.splash.view.SplashScreen
import dev.korryr.notecraft.ui.theme.NoteCraftTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            ContentCollection(
                navigationSubGraphs = navigationSubGraphs,
                navController,
            )

        }
    }
}

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NoteCraftTheme {
                SplashScreen()
            }
        }

        // Navigate to MainActivity after 3 seconds
        lifecycleScope.launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}


@Composable
fun MainContent(
    themeManager: ThemeManager,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to NoteCraft!",
                modifier = modifier
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Beautiful Theme Toggle Button
            ElegantThemeToggle(
                isDarkMode = themeManager.isDarkMode,
                onToggle = { themeManager.toggleTheme() }
            )


            Spacer(modifier = Modifier.height(32.dp))

            // Beautiful Theme Toggle Button
            ThemeToggleButton(
                isDarkMode = themeManager.isDarkMode,
                onToggle = { themeManager.toggleTheme() }
            )
        }
    }
}

///////////////////////////////////////////////////////////////////////////
// theme viemodle
///////////////////////////////////////////////////////////////////////////

class ThemeManager : ViewModel() {
    var isDarkMode by mutableStateOf(false)
        private set

    fun toggleTheme() {
        isDarkMode = !isDarkMode
    }
}

@Composable
fun ThemeToggleButton(
    isDarkMode: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Animation values
    val animatedOffset by animateFloatAsState(
        targetValue = if (isDarkMode) 1f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "toggle_offset"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isDarkMode) {
            Color(25, 42, 86) // Navy blue for dark mode
        } else {
            Color(193, 154, 107) // Camel for light mode
        },
        animationSpec = tween(durationMillis = 300),
        label = "background_color"
    )

    val thumbColor by animateColorAsState(
        targetValue = if (isDarkMode) {
            Color(193, 154, 107) // Camel thumb in dark mode
        } else {
            Color(255, 255, 255) // White thumb in light mode
        },
        animationSpec = tween(durationMillis = 300),
        label = "thumb_color"
    )

    Box(
        modifier = modifier
            .width(120.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(backgroundColor)
            .border(
                width = 2.dp,
                color = Color(54, 69, 79).copy(alpha = 0.3f),
                shape = RoundedCornerShape(25.dp)
            )
            .clickable { onToggle() }
            .padding(4.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        // Sliding thumb with icon
        Box(
            modifier = Modifier
                .offset(x = (66.dp * animatedOffset))
                .size(42.dp)
                .clip(CircleShape)
                .background(thumbColor)
                .border(
                    width = 1.dp,
                    color = Color(54, 69, 79).copy(alpha = 0.2f),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (isDarkMode) Icons.Default.DarkMode else Icons.Default.LightMode,
                contentDescription = if (isDarkMode) "Dark Mode" else "Light Mode",
                tint = if (isDarkMode) Color(25, 42, 86) else Color(193, 154, 107),
                modifier = Modifier.size(20.dp)
            )
        }

        // Background icons for context
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Light mode icon (left side)
            Icon(
                imageVector = Icons.Default.LightMode,
                contentDescription = "Light Mode",
                tint = if (!isDarkMode) Color.Transparent else Color.White.copy(alpha = 0.6f),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(16.dp)
            )

            // Dark mode icon (right side)
            Icon(
                imageVector = Icons.Default.DarkMode,
                contentDescription = "Dark Mode",
                tint = if (isDarkMode) Color.Transparent else Color.White.copy(alpha = 0.6f),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )
        }
    }
}

// 4. Alternative Elegant Card Style Toggle Button
@Composable
fun ElegantThemeToggle(
    isDarkMode: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable { onToggle() }
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = if (isDarkMode) Icons.Default.DarkMode else Icons.Default.LightMode,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = if (isDarkMode) "Dark Mode" else "Light Mode",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            Switch(
                checked = isDarkMode,
                onCheckedChange = { onToggle() },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(193, 154, 107), // Camel
                    checkedTrackColor = Color(25, 42, 86),     // Navy
                    uncheckedThumbColor = Color(255, 255, 255), // White
                    uncheckedTrackColor = Color(193, 154, 107)  // Camel
                )
            )
        }
    }
}
