package com.example.project_nav_ui_act.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.HelpCenter
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.project_nav_ui_act.ui.components.SereneCard
import com.example.project_nav_ui_act.ui.components.SereneListItem
import com.example.project_nav_ui_act.ui.components.SereneSwitch
import com.example.project_nav_ui_act.ui.theme.HeadlineMd
import com.example.project_nav_ui_act.ui.theme.HeadlineXlMobile
import com.example.project_nav_ui_act.ui.theme.LavenderAccent
import com.example.project_nav_ui_act.ui.theme.LavenderPrimary
import com.example.project_nav_ui_act.ui.theme.LilacPastel
import com.example.project_nav_ui_act.ui.theme.NeutralSlate
import com.example.project_nav_ui_act.ui.theme.SereneShapes
import com.example.project_nav_ui_act.ui.theme.SurfaceContainerActive

@Composable
fun ProfileScreen() {
    var darkModeEnabled by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Profile",
                style = HeadlineXlMobile,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        // Profile Header Card
        item {
            SereneCard(padding = 16.dp) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(contentAlignment = Alignment.BottomEnd) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(SereneShapes.Full)
                                .background(SurfaceContainerActive)
                        ) {
                            Text(
                                text = "SA",
                                style = HeadlineMd,
                                color = LavenderPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(20.dp)
                                .clip(SereneShapes.Full)
                                .background(LavenderPrimary)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(12.dp)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Sarah Amalia",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Box(
                                modifier = Modifier
                                    .clip(SereneShapes.Full)
                                    .background(LilacPastel)
                                    .clickable { }
                                    .padding(horizontal = 10.dp, vertical = 4.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = null,
                                        tint = LavenderPrimary,
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Text(
                                        text = "Edit Profil",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = LavenderPrimary,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                        Text(
                            text = "@sarah.amalia",
                            style = MaterialTheme.typography.bodyMedium,
                            color = NeutralSlate
                        )
                        Text(
                            text = "sarah.amalia@mindful.io",
                            style = MaterialTheme.typography.labelMedium,
                            color = LavenderAccent
                        )
                    }
                }
            }
        }

        // Bento Stats Row
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Stat 1
                Box(modifier = Modifier.weight(1f)) {
                    SereneCard(padding = 12.dp) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(SereneShapes.Full)
                                    .background(LilacPastel)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = null,
                                    tint = LavenderPrimary,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                            Text(
                                text = "12",
                                style = HeadlineMd,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Favorit",
                                style = MaterialTheme.typography.labelSmall,
                                color = NeutralSlate
                            )
                        }
                    }
                }

                // Stat 2
                Box(modifier = Modifier.weight(1f)) {
                    SereneCard(padding = 12.dp) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(SereneShapes.Full)
                                    .background(SurfaceContainerActive)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bolt,
                                    contentDescription = null,
                                    tint = LavenderPrimary,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                            Text(
                                text = "28",
                                style = HeadlineMd,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Aktivitas",
                                style = MaterialTheme.typography.labelSmall,
                                color = NeutralSlate
                            )
                        }
                    }
                }

                // Stat 3
                Box(modifier = Modifier.weight(1f)) {
                    SereneCard(padding = 12.dp) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(SereneShapes.Full)
                                    .background(LilacPastel)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(0xFFFFB300),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                            Text(
                                text = "4.9",
                                style = HeadlineMd,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Rating",
                                style = MaterialTheme.typography.labelSmall,
                                color = NeutralSlate
                            )
                        }
                    }
                }
            }
        }

        // Group 1: Akun
        item {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Akun",
                    style = MaterialTheme.typography.labelMedium,
                    color = NeutralSlate,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
                SereneCard(padding = 4.dp) {
                    Column {
                        SereneListItem(
                            title = "Informasi Pribadi",
                            subtitle = "Kelola data diri & kontak",
                            icon = Icons.Default.Badge,
                            onClick = { }
                        )
                        SereneListItem(
                            title = "Keamanan & Kata Sandi",
                            subtitle = "PIN, Sandi & Biometrik",
                            icon = Icons.Default.LockReset,
                            onClick = { }
                        )
                        SereneListItem(
                            title = "Notifikasi",
                            subtitle = "Email, push & pesan promosi",
                            icon = Icons.Default.NotificationsActive,
                            onClick = { }
                        )
                    }
                }
            }
        }

        // Group 2: Preferensi
        item {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Preferensi",
                    style = MaterialTheme.typography.labelMedium,
                    color = NeutralSlate,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
                SereneCard(padding = 4.dp) {
                    Column {
                        SereneListItem(
                            title = "Bahasa",
                            icon = Icons.Default.Translate,
                            trailingText = "Bahasa Indonesia",
                            onClick = { }
                        )
                        SereneListItem(
                            title = "Tema Tampilan",
                            icon = Icons.Default.Palette,
                            trailingText = "Lavendel Halus",
                            onClick = { }
                        )

                        // Dark mode toggle row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp, horizontal = 12.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(SereneShapes.Md)
                                    .background(SurfaceContainerActive)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DarkMode,
                                    contentDescription = null,
                                    tint = LavenderAccent,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Mode Gelap",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Menyesuaikan mata di malam hari",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = NeutralSlate
                                )
                            }
                            SereneSwitch(
                                checked = darkModeEnabled,
                                onCheckedChange = { darkModeEnabled = it }
                            )
                        }
                    }
                }
            }
        }

        // Group 3: Bantuan & Lainnya
        item {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Bantuan & Lainnya",
                    style = MaterialTheme.typography.labelMedium,
                    color = NeutralSlate,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
                SereneCard(padding = 4.dp) {
                    Column {
                        SereneListItem(
                            title = "Pusat Bantuan",
                            icon = Icons.AutoMirrored.Filled.HelpCenter,
                            onClick = { }
                        )
                        SereneListItem(
                            title = "Syarat & Ketentuan",
                            icon = Icons.Default.Gavel,
                            onClick = { }
                        )
                        SereneListItem(
                            title = "Tentang Aplikasi",
                            icon = Icons.Default.Info,
                            trailingText = "v2.4.1",
                            onClick = { }
                        )
                    }
                }
            }
        }

        // Logout Section
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(SereneShapes.Full)
                        .background(Color(0xFFFFDAD6))
                        .clickable { }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = null,
                            tint = Color(0xFF93000A),
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Keluar",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFF93000A),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Tersambung dengan aman • Mindful Living 2024",
                    style = MaterialTheme.typography.labelSmall,
                    color = NeutralSlate
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
