package com.example.project_nav_ui_act

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.project_nav_ui_act.ui.components.SereneBottomNavigationBar
import com.example.project_nav_ui_act.ui.components.SereneNavigationItem
import com.example.project_nav_ui_act.ui.screens.FavoritesScreen
import com.example.project_nav_ui_act.ui.screens.HomeScreen
import com.example.project_nav_ui_act.ui.screens.ProfileScreen
import com.example.project_nav_ui_act.ui.theme.Project_Nav_UI_ActTheme
import com.example.project_nav_ui_act.ui.theme.SereneCanvasBase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project_Nav_UI_ActTheme {
                SereneApp()
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    FAVORITES("Favorites", Icons.Default.Favorite),
    PROFILE("Profile", Icons.Default.Person),
}

@Composable
fun SereneApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    Scaffold(
        bottomBar = {
            SereneBottomNavigationBar {
                AppDestinations.entries.forEach { destination ->
                    SereneNavigationItem(
                        selected = currentDestination == destination,
                        onClick = { currentDestination = destination },
                        icon = destination.icon,
                        label = destination.label
                    )
                }
            }
        },
        containerColor = SereneCanvasBase,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentDestination) {
                AppDestinations.HOME -> HomeScreen()
                AppDestinations.FAVORITES -> FavoritesScreen()
                AppDestinations.PROFILE -> ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SereneAppPreview() {
    Project_Nav_UI_ActTheme {
        SereneApp()
    }
}
