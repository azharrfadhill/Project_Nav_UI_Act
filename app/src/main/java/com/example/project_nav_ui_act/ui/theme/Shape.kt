package com.example.project_nav_ui_act.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

object SereneShapes {
    val Sm = RoundedCornerShape(4.dp)
    val Default = RoundedCornerShape(8.dp)
    val Md = RoundedCornerShape(12.dp)
    val Lg = RoundedCornerShape(16.dp)
    val Xl = RoundedCornerShape(24.dp)
    val Full = CircleShape
}

val SereneM3Shapes = Shapes(
    extraSmall = SereneShapes.Sm,
    small = SereneShapes.Default,
    medium = SereneShapes.Md,
    large = SereneShapes.Lg,
    extraLarge = SereneShapes.Xl
)
