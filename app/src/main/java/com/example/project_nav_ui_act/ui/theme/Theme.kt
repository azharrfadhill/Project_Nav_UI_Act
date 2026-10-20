package com.example.project_nav_ui_act.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightSereneColorScheme = lightColorScheme(
    primary = LavenderPrimary,
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    inversePrimary = InversePrimaryLight,
    secondary = WisteriaSecondary,
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    tertiary = LilacTertiary,
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = TertiaryContainerLight,
    onTertiaryContainer = OnTertiaryContainerLight,
    background = SereneCanvasBase,
    onBackground = OnSurfaceLight,
    surface = SereneCanvasBase,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceContainerHighest,
    onSurfaceVariant = OnSurfaceVariantLight,
    surfaceTint = SurfaceTintLight,
    inverseSurface = InverseSurfaceLight,
    inverseOnSurface = InverseOnSurfaceLight,
    outline = OutlineLight,
    outlineVariant = OutlineVariantLight,
    error = ErrorLight,
    onError = OnErrorLight,
    errorContainer = ErrorContainerLight,
    onErrorContainer = OnErrorContainerLight
)

private val DarkSereneColorScheme = darkColorScheme(
    primary = InversePrimaryLight,
    onPrimary = OnPrimaryFixed,
    primaryContainer = LavenderPrimary,
    onPrimaryContainer = OnPrimaryContainerLight,
    inversePrimary = LavenderPrimary,
    secondary = WisteriaLight,
    onSecondary = OnSecondaryFixed,
    secondaryContainer = WisteriaSecondary,
    onSecondaryContainer = SecondaryFixed,
    tertiary = LilacPastel,
    onTertiary = OnTertiaryFixed,
    tertiaryContainer = LilacTertiary,
    onTertiaryContainer = TertiaryFixed,
    background = InverseSurfaceLight,
    onBackground = InverseOnSurfaceLight,
    surface = InverseSurfaceLight,
    onSurface = InverseOnSurfaceLight,
    surfaceVariant = NeutralSlate,
    onSurfaceVariant = SurfaceContainerHighest,
    surfaceTint = SurfaceTintLight,
    inverseSurface = SereneCanvasBase,
    inverseOnSurface = OnSurfaceLight,
    outline = OutlineVariantLight,
    outlineVariant = OutlineLight,
    error = ErrorContainerLight,
    onError = OnErrorContainerLight,
    errorContainer = ErrorLight,
    onErrorContainer = OnErrorLight
)

@Composable
fun Project_Nav_UI_ActTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkSereneColorScheme else LightSereneColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = SereneTypography,
        shapes = SereneM3Shapes,
        content = content
    )
}
