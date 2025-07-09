package dev.korryr.notecraft.application

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.korryr.notecraft.ui.components.home.view.HomePage
import dev.korryr.notecraft.ui.theme.NoteCraftTheme

@Composable
fun ContentCollection(
    navigationSubGraphs: NavigationSubGraphs,
    navHostController: NavHostController,
) {
    val themeManager: ThemeManager = viewModel()

    NoteCraftTheme (
        darkTheme = themeManager.isDarkMode
    ){
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->

            HomePage(
                modifier = Modifier.padding(innerPadding)
            )
            //SplashScreen()
//                    MainContent(
//                        themeManager = themeManager,
//                        modifier = Modifier.padding(innerPadding)
//                    )
        }
    }
}