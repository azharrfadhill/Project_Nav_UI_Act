package com.example.project_nav_ui_act.ui.screens

import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.project_nav_ui_act.ui.components.SereneCard
import com.example.project_nav_ui_act.ui.components.SereneFilterChip
import com.example.project_nav_ui_act.ui.components.SereneHighlightCard
import com.example.project_nav_ui_act.ui.components.SerenePrimaryButton
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

data class ProductItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val price: String,
    val originalPrice: String? = null,
    val rating: String,
    val reviews: String,
    val badge: String? = null
)

@Composable
fun HomeScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Populer") }
    val categories = listOf("Populer", "Baru", "Rekomendasi", "Kategori", "Diskon")

    val products = remember {
        listOf(
            ProductItem("1", "Ceramic Zen Aroma Diffuser", "Relaksasi rumah dengan mist halus", "Rp 249.000", "Rp 320.000", "4.9", "(128)", "Terlaris"),
            ProductItem("2", "Botol Termos Pastel Lilac", "Tahan dingin hingga 24 jam", "Rp 185.000", null, "4.8", "(94)", null),
            ProductItem("3", "Buku Jurnal Mindfulness", "Kertas ramah lingkungan 120gsm", "Rp 96.000", "Rp 120.000", "5.0", "(62)", "Diskon 20%"),
            ProductItem("4", "Lilin Terapi Lavender Bliss", "Bahan alami 100% soy wax", "Rp 145.000", null, "4.7", "(81)", null)
        )
    }

    val favoritesState = remember { mutableStateMapOf<String, Boolean>() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Greeting & Header
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(SereneShapes.Full)
                            .background(SurfaceContainerActive)
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = null,
                            tint = LavenderPrimary,
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Pilihan Hari Ini",
                            style = MaterialTheme.typography.labelSmall,
                            color = LavenderPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Halo, Selamat Datang!",
                        style = HeadlineXlMobile,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Temukan inspirasi dan produk favoritmu.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = NeutralSlate
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(SereneShapes.Full)
                        .background(SurfaceContainerActive)
                ) {
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = "Status",
                        tint = LavenderPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        // Search Bar & Filter
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
                        placeholder = "Cari tren, produk, atau gaya...",
                        leadingIcon = Icons.Default.Search,
                        trailingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Default.Mic,
                                    contentDescription = "Voice search",
                                    tint = NeutralSlate,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(SereneShapes.Full)
                        .background(LavenderPrimary)
                        .clickable { }
                ) {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = "Filter",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        // Featured Carousel Banner
        item {
            SereneHighlightCard(padding = 20.dp) {
                Column(
                    modifier = Modifier.height(160.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(SereneShapes.Full)
                                .background(Color.White.copy(alpha = 0.8f))
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "Spesial Minggu Ini",
                                style = MaterialTheme.typography.labelMedium,
                                color = LavenderPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(SereneShapes.Full)
                                .background(Color.White.copy(alpha = 0.6f))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .clip(SereneShapes.Full)
                                        .background(LavenderPrimary)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Terbatas",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = NeutralSlate
                                )
                            }
                        }
                    }

                    Column {
                        Text(
                            text = "Koleksi Zen Pastel & Suasana Tenang",
                            style = HeadlineMd,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Sentuhan wisteria elegan untuk keseharianmu.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = NeutralSlate,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        SerenePrimaryButton(
                            text = "Jelajahi Sekarang",
                            onClick = { },
                            icon = Icons.AutoMirrored.Filled.ArrowForward
                        )

                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Box(modifier = Modifier.size(20.dp, 6.dp).clip(SereneShapes.Full).background(LavenderPrimary))
                            Box(modifier = Modifier.size(6.dp).clip(SereneShapes.Full).background(NeutralSlate.copy(alpha = 0.3f)))
                            Box(modifier = Modifier.size(6.dp).clip(SereneShapes.Full).background(NeutralSlate.copy(alpha = 0.3f)))
                        }
                    }
                }
            }
        }

        // Quick Category Filter Chips
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Kategori Populer",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Lihat Semua",
                        style = MaterialTheme.typography.labelLarge,
                        color = LavenderPrimary,
                        modifier = Modifier.clickable { }
                    )
                }
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(categories) { category ->
                        SereneFilterChip(
                            selected = selectedCategory == category,
                            onClick = { selectedCategory = category },
                            label = category
                        )
                    }
                }
            }
        }

        // Featured Products / Content Cards (2-Column Grid simulation using Rows of 2 items)
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Pilihan Terbaik",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Box(
                            modifier = Modifier
                                .clip(SereneShapes.Full)
                                .background(LilacPastel)
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "${products.size} Produk",
                                style = MaterialTheme.typography.labelSmall,
                                color = LavenderPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { }
                    ) {
                        Text(
                            text = "Semua",
                            style = MaterialTheme.typography.labelLarge,
                            color = LavenderPrimary
                        )
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = LavenderPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                // 2 Columns grid layout
                val chunkedProducts = products.chunked(2)
                chunkedProducts.forEach { rowProducts ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        rowProducts.forEach { product ->
                            Box(modifier = Modifier.weight(1f)) {
                                ProductCard(
                                    product = product,
                                    isFavorite = favoritesState[product.id] == true,
                                    onFavoriteClick = {
                                        favoritesState[product.id] = !(favoritesState[product.id] == true)
                                    }
                                )
                            }
                        }
                        if (rowProducts.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }

        // Recent Activity & Trending Feed Section
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Aktivitas & Tren Komunitas",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Real-time",
                        style = MaterialTheme.typography.labelSmall,
                        color = NeutralSlate
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    // Activity 1
                    SereneCard(padding = 12.dp) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(SereneShapes.Full)
                                    .background(SurfaceContainerActive)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Spa,
                                    contentDescription = null,
                                    tint = LavenderPrimary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Aulia S. baru saja membeli Diffuser Zen",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "2 menit yang lalu • Jakarta Selatan",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = NeutralSlate
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = NeutralSlate,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    // Activity 2
                    SereneCard(padding = 12.dp) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(SereneShapes.Full)
                                    .background(LilacPastel)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = null,
                                    tint = LavenderPrimary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Rian K. menyukai Lilin Terapi Lavender",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "8 menit yang lalu • Bandung",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = NeutralSlate
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = NeutralSlate,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    // Activity 3 Tip
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(SereneShapes.Lg)
                            .background(SurfaceContainerActive.copy(alpha = 0.6f))
                            .padding(14.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(SereneShapes.Full)
                                    .background(Color.White)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = null,
                                    tint = LavenderPrimary,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Tips Kenyamanan Ruang",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "Ciptakan sudut baca yang tenang dengan pencahayaan hangat dan aroma menenangkan untuk menjaga fokus harianmu.",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = NeutralSlate
                                )
                            }
                        }
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
fun ProductCard(
    product: ProductItem,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    val heartScale by animateFloatAsState(targetValue = if (isFavorite) 1.2f else 1.0f, label = "heartScale")

    SereneCard(padding = 10.dp) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(SereneShapes.Md)
                    .background(SurfaceContainerActive)
            ) {
                // Placeholder illustration content box
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null,
                        tint = LavenderAccent.copy(alpha = 0.5f),
                        modifier = Modifier.size(48.dp)
                    )
                }

                // Favorite Button
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(32.dp)
                        .clip(SereneShapes.Full)
                        .background(Color.White.copy(alpha = 0.85f))
                        .clickable { onFavoriteClick() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else NeutralSlate,
                        modifier = Modifier
                            .size(16.dp)
                            .scale(heartScale)
                    )
                }

                if (product.badge != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(8.dp)
                            .clip(SereneShapes.Sm)
                            .background(Color.White.copy(alpha = 0.9f))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = product.badge,
                            style = MaterialTheme.typography.labelSmall,
                            color = LavenderPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFB300),
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = product.rating,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = product.reviews,
                    style = MaterialTheme.typography.labelSmall,
                    color = NeutralSlate
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = product.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = product.subtitle,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = NeutralSlate
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    if (product.originalPrice != null) {
                        Text(
                            text = product.originalPrice,
                            style = MaterialTheme.typography.labelSmall,
                            color = NeutralSlate,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                    Text(
                        text = product.price,
                        style = MaterialTheme.typography.titleMedium,
                        color = LavenderPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(SereneShapes.Full)
                        .background(LilacPastel)
                        .clickable { }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to cart",
                        tint = LavenderPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
