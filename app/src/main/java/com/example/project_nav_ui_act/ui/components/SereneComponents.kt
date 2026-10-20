package com.example.project_nav_ui_act.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.project_nav_ui_act.ui.theme.LavenderAccent
import com.example.project_nav_ui_act.ui.theme.LavenderPrimary
import com.example.project_nav_ui_act.ui.theme.LilacPastel
import com.example.project_nav_ui_act.ui.theme.NeutralSlate
import com.example.project_nav_ui_act.ui.theme.SereneCanvasAlt
import com.example.project_nav_ui_act.ui.theme.SereneShapes
import com.example.project_nav_ui_act.ui.theme.SoftBorder
import com.example.project_nav_ui_act.ui.theme.SurfaceContainerActive

/**
 * Serene Primary Button
 * Pill-shaped with full #644AAE fill, white text, and ambient lavender shadow.
 */
@Composable
fun SerenePrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = LavenderPrimary,
            contentColor = Color.White
        ),
        modifier = modifier
            .shadow(
                elevation = 6.dp,
                shape = CircleShape,
                ambientColor = LavenderAccent,
                spotColor = LavenderAccent
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

/**
 * Serene Soft / Secondary Button
 * Filled with #F3EFFC, typography in #8A70D6, no border.
 */
@Composable
fun SereneSoftButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = SurfaceContainerActive,
            contentColor = LavenderAccent
        ),
        elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

/**
 * Serene Ghost Button
 * Transparent fill, neutral slate text, soft press highlight.
 */
@Composable
fun SereneGhostButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    OutlinedButton(
        onClick = onClick,
        shape = CircleShape,
        border = BorderStroke(1.dp, SoftBorder),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = NeutralSlate
        ),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

/**
 * Serene Standard Card
 * Surface color #FFFFFF, rounded-lg (16dp), 1px soft stroke #EBE8F3.
 */
@Composable
fun SereneCard(
    modifier: Modifier = Modifier,
    padding: Dp = 16.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        shape = SereneShapes.Lg,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, SoftBorder),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(padding)
        ) {
            content()
        }
    }
}

/**
 * Serene Highlight Card
 * Subtle gradient from #FFFFFF down to #F7F4FD, with rounded-lg bounds.
 */
@Composable
fun SereneHighlightCard(
    modifier: Modifier = Modifier,
    padding: Dp = 20.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .clip(SereneShapes.Lg)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFF7F4FD)
                    )
                )
            )
            .border(1.dp, SoftBorder, SereneShapes.Lg)
            .shadow(
                elevation = 4.dp,
                shape = SereneShapes.Lg,
                ambientColor = LavenderAccent,
                spotColor = LavenderAccent
            )
            .padding(padding)
    ) {
        Column {
            content()
        }
    }
}

/**
 * Serene List Item
 * Clean row with leading 40dp circular or 12dp squircle pastel avatar container (#F3EFFC) housing a #8A70D6 icon,
 * title, subtitle, and trailing chevron or action.
 */
@Composable
fun SereneListItem(
    title: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    trailingText: String? = null,
    onClick: (() -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(SereneShapes.Lg)
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(vertical = 12.dp, horizontal = 12.dp)
    ) {
        // Pastel icon container (12dp squircle)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(42.dp)
                .clip(SereneShapes.Md)
                .background(SurfaceContainerActive)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = LavenderAccent,
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (!subtitle.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = NeutralSlate
                )
            }
        }

        if (trailingText != null) {
            Text(
                text = trailingText,
                style = MaterialTheme.typography.labelMedium,
                color = NeutralSlate,
                modifier = Modifier.padding(end = 4.dp)
            )
        } else if (onClick != null) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = NeutralSlate.copy(alpha = 0.6f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

/**
 * Serene Chip / Filter
 * Inactive: #FFFFFF fill, 1px #EBE8F3 outline, neutral text.
 * Active: #E8DFF5 pastel fill, #8A70D6 text, optional check icon.
 */
@Composable
fun SereneFilterChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) LilacPastel else Color.White,
        label = "chipBg"
    )
    val textColor by animateColorAsState(
        targetValue = if (selected) LavenderPrimary else NeutralSlate,
        label = "chipText"
    )
    val borderColor by animateColorAsState(
        targetValue = if (selected) LilacPastel else SoftBorder,
        label = "chipBorder"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .border(1.dp, borderColor, CircleShape)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (selected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = LavenderPrimary,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
            } else if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = NeutralSlate,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
            }

            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge,
                color = textColor
            )
        }
    }
}

/**
 * Serene Form Input Field
 * Inset #F9F8FD background shifting to #FFFFFF with 1.5dp #8A70D6 outline on focus.
 */
@Composable
fun SereneTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    leadingIcon: ImageVector? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val backgroundColor by animateColorAsState(
        targetValue = if (isFocused) Color.White else SereneCanvasAlt,
        label = "inputBg"
    )

    val borderColor by animateColorAsState(
        targetValue = if (isFocused) LavenderAccent else SoftBorder,
        label = "inputBorder"
    )

    val borderWidth = if (isFocused) 1.5.dp else 1.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(SereneShapes.Md)
            .background(backgroundColor)
            .border(borderWidth, borderColor, SereneShapes.Md)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = if (isFocused) LavenderAccent else NeutralSlate,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
            }

            Box(modifier = Modifier.weight(1f)) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyMedium,
                        color = NeutralSlate.copy(alpha = 0.6f)
                    )
                }

                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    ),
                    interactionSource = interactionSource,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            if (trailingIcon != null) {
                Spacer(modifier = Modifier.width(8.dp))
                trailingIcon()
            }
        }
    }
}

/**
 * Serene Switch
 * Utilizes #E8DFF5 track that switches to #8A70D6 when engaged, with white thumb.
 */
@Composable
fun SereneSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = LavenderAccent,
            uncheckedThumbColor = Color.White,
            uncheckedTrackColor = LilacPastel,
            uncheckedBorderColor = SoftBorder
        ),
        modifier = modifier
    )
}

/**
 * Serene Bottom Navigation Bar
 * Frosted white background, active item encased in soft lavender pill container (#E8DFF5)
 * with icon and label in #8A70D6. Hairline divider at top (#EBE8F3).
 */
@Composable
fun SereneBottomNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(SoftBorder)
        )
        NavigationBar(
            containerColor = Color.White.copy(alpha = 0.95f),
            tonalElevation = 8.dp,
            content = content
        )
    }
}

/**
 * Serene Bottom Navigation Item wrapper
 */
@Composable
fun RowScope.SereneNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    label: String
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(22.dp)
            )
        },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = LavenderPrimary,
            selectedTextColor = LavenderPrimary,
            indicatorColor = LilacPastel,
            unselectedIconColor = NeutralSlate.copy(alpha = 0.65f),
            unselectedTextColor = NeutralSlate.copy(alpha = 0.65f)
        )
    )
}
