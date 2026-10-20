package com.example.project_nav_ui_act.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.material.icons.filled.ViewAgenda
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.project_nav_ui_act.ui.components.SereneFilterChip
import com.example.project_nav_ui_act.ui.components.SereneSoftButton
import com.example.project_nav_ui_act.ui.components.SereneTextField
import com.example.project_nav_ui_act.ui.theme.HeadlineMd
import com.example.project_nav_ui_act.ui.theme.HeadlineXlMobile
import com.example.project_nav_ui_act.ui.theme.LavenderAccent
import com.example.project_nav_ui_act.ui.theme.LavenderPrimary
import com.example.project_nav_ui_act.ui.theme.LilacPastel
import com.example.project_nav_ui_act.ui.theme.NeutralSlate
import com.example.project_nav_ui_act.ui.theme.SereneShapes
import com.example.project_nav_ui_act.ui.theme.SurfaceContainerActive

data class FavoriteItem(
    val id: String,
    val category: String,
    val subcategory: String,
    val title: String,
    val rating: String,
    val savedTime: String,
    val price: String,
    val unit: String? = null
)

data class RecommendationItem(
    val title: String,
    val category: String,
    val price: String,
    val rating: String,
    val match: String
)

@Composable
fun FavoritesScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("Semua") }
    var isGridView by remember { mutableStateOf(false) }

    val filterOptions = listOf("Semua", "Koleksi Estetik", "Disimpan Baru-baru ini", "Pilihan Relaksasi")

    val favorites = remember {
        listOf(
            FavoriteItem("1", "Dekorasi Rumah", "Studio", "Vase Keramik Aethel", "4.9", "Disimpan 2 hari lalu", "Rp 480.000"),
            FavoriteItem("2", "Wellness & Spa", "Relaksasi", "Suaka Alam Botanika", "4.95", "Disimpan kemarin", "Rp 850.000", "/sesi"),
            FavoriteItem("3", "Gaya Hidup", "Tekstil", "Selimut Linen Organik", "4.8", "Disimpan 1 minggu lalu", "Rp 620.000")
        )
    }

    val recommendations = remember {
        listOf(
            RecommendationItem("Diffuser Aromaterapi", "Wellness Aura", "Rp 399.000", "4.9", "98% Cocok"),
            RecommendationItem("Lilin Kedelai Lavender", "Home Fragrance", "Rp 215.000", "4.8", "94% Cocok"),
            RecommendationItem("Lampu Meja Lune", "Pencahayaan", "Rp 750.000", "4.9", "91% Cocok")
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Favorit Saya",
                        style = HeadlineXlMobile,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Box(
                        modifier = Modifier
                            .clip(SereneShapes.Full)
                            .background(LilacPastel)
                            .padding(horizontal = 10.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "12 Tersimpan",
                            style = MaterialTheme.typography.labelSmall,
                            color = LavenderPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(SereneShapes.Full)
                        .background(SurfaceContainerActive)
                        .clickable { isGridView = !isGridView }
                ) {
                    Icon(
                        imageVector = if (isGridView) Icons.Default.ViewAgenda else Icons.Default.Dashboard,
                        contentDescription = "Toggle View",
                        tint = NeutralSlate,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Koleksi pilihan yang Anda simpan untuk eksplorasi lebih lanjut.",
                style = MaterialTheme.typography.bodyMedium,
                color = NeutralSlate
            )
        }

        // Search & Sort Controls
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    SereneTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = "Cari dalam favorit...",
                        leadingIcon = Icons.Default.Search
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(SereneShapes.Full)
                        .background(Color.White)
                        .clickable { }
                        .padding(horizontal = 14.dp, vertical = 12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.SwapVert,
                            contentDescription = null,
                            tint = LavenderPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "Urutkan",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        // Filter Chips
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filterOptions) { filter ->
                    SereneFilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = filter
                    )
                }
            }
        }

        // Favorites List / Grid
        item {
            if (isGridView) {
                val chunked = favorites.chunked(2)
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    chunked.forEach { rowItems ->
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            rowItems.forEach { item ->
                                Box(modifier = Modifier.weight(1f)) {
                                    FavoriteGridCard(item = item)
                                }
                            }
                            if (rowItems.size == 1) Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    favorites.forEach { item ->
                        FavoriteListCard(item = item)
                    }
                }
            }
        }

        // Recommendations Section
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = "Rekomendasi Berdasarkan Favorit",
                            style = HeadlineMd,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Disusun khusus selaras dengan preferensi estetika Anda",
                            style = MaterialTheme.typography.bodyMedium,
                            color = NeutralSlate
                        )
                    }
                }

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(recommendations) { reco ->
                        RecommendationCard(reco = reco)
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun FavoriteListCard(item: FavoriteItem) {
    SereneCard(padding = 16.dp) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(SereneShapes.Md)
                    .background(SurfaceContainerActive)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = LavenderAccent.copy(alpha = 0.4f),
                        modifier = Modifier.size(36.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(6.dp)
                        .clip(SereneShapes.Full)
                        .background(Color.White.copy(alpha = 0.9f))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = item.subcategory,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = item.category.uppercase(),
                        style = MaterialTheme.typography.labelSmall,
                        color = LavenderPrimary,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(SereneShapes.Full)
                            .background(LilacPastel)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Saved",
                            tint = LavenderPrimary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFB300),
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = item.rating,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Box(modifier = Modifier.size(3.dp).clip(SereneShapes.Full).background(NeutralSlate))
                    Text(
                        text = item.savedTime,
                        style = MaterialTheme.typography.labelSmall,
                        color = NeutralSlate
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = item.price + (item.unit ?: ""),
                        style = MaterialTheme.typography.titleMedium,
                        color = LavenderPrimary,
                        fontWeight = FontWeight.Bold
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        IconButton(onClick = { }, modifier = Modifier.size(32.dp)) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share",
                                tint = NeutralSlate,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        SereneSoftButton(
                            text = "Detail",
                            onClick = { }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FavoriteGridCard(item: FavoriteItem) {
    SereneCard(padding = 10.dp) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(SereneShapes.Md)
                    .background(SurfaceContainerActive)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = LavenderAccent.copy(alpha = 0.4f),
                        modifier = Modifier.size(32.dp)
                    )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                        .size(30.dp)
                        .clip(SereneShapes.Full)
                        .background(LilacPastel)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = LavenderPrimary,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.price,
                    style = MaterialTheme.typography.labelLarge,
                    color = LavenderPrimary,
                    fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFB300),
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = item.rating,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun RecommendationCard(reco: RecommendationItem) {
    SereneCard(padding = 10.dp) {
        Column(
            modifier = Modifier.width(160.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .clip(SereneShapes.Md)
                    .background(SurfaceContainerActive)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = LavenderAccent.copy(alpha = 0.4f),
                        modifier = Modifier.size(32.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(6.dp)
                        .clip(SereneShapes.Full)
                        .background(Color.White.copy(alpha = 0.9f))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = reco.match,
                        style = MaterialTheme.typography.labelSmall,
                        color = LavenderPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Text(
                text = reco.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = reco.category,
                style = MaterialTheme.typography.labelSmall,
                color = NeutralSlate
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = reco.price,
                    style = MaterialTheme.typography.labelLarge,
                    color = LavenderPrimary,
                    fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFB300),
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = reco.rating,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
