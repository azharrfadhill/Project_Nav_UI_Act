package com.example.project_nav_ui_act.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.project_nav_ui_act.R

private val fontProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val plusJakartaSansFontName = GoogleFont("Plus Jakarta Sans")

val PlusJakartaSans = FontFamily(
    Font(googleFont = plusJakartaSansFontName, fontProvider = fontProvider, weight = FontWeight.Normal),
    Font(googleFont = plusJakartaSansFontName, fontProvider = fontProvider, weight = FontWeight.Medium),
    Font(googleFont = plusJakartaSansFontName, fontProvider = fontProvider, weight = FontWeight.SemiBold),
    Font(googleFont = plusJakartaSansFontName, fontProvider = fontProvider, weight = FontWeight.Bold)
)

// Custom Type Styles as per Serene Lavender Specification
val HeadlineXl = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W700,
    fontSize = 32.sp,
    lineHeight = 40.sp
)

val HeadlineXlMobile = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W700,
    fontSize = 26.sp,
    lineHeight = 34.sp
)

val HeadlineLg = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W600,
    fontSize = 24.sp,
    lineHeight = 32.sp
)

val HeadlineMd = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W600,
    fontSize = 20.sp,
    lineHeight = 28.sp
)

val TitleMd = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W600,
    fontSize = 17.sp,
    lineHeight = 24.sp
)

val BodyLg = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W400,
    fontSize = 16.sp,
    lineHeight = 24.sp
)

val BodyMd = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W400,
    fontSize = 14.sp,
    lineHeight = 20.sp
)

val LabelLg = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W600,
    fontSize = 13.sp,
    lineHeight = 18.sp
)

val LabelMd = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W500,
    fontSize = 12.sp,
    lineHeight = 16.sp
)

val LabelSm = TextStyle(
    fontFamily = PlusJakartaSans,
    fontWeight = FontWeight.W600,
    fontSize = 10.sp,
    lineHeight = 14.sp
)

val SereneTypography = Typography(
    displayLarge = HeadlineXl,
    displayMedium = HeadlineXlMobile,
    headlineLarge = HeadlineLg,
    headlineMedium = HeadlineMd,
    titleLarge = HeadlineMd,
    titleMedium = TitleMd,
    titleSmall = LabelLg,
    bodyLarge = BodyLg,
    bodyMedium = BodyMd,
    bodySmall = LabelMd,
    labelLarge = LabelLg,
    labelMedium = LabelMd,
    labelSmall = LabelSm
)
