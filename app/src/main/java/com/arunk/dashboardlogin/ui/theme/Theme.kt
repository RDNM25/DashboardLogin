package com.arunk.dashboardlogin.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
private val AppColorScheme = lightColorScheme(
    primary = BrandRed,
    onPrimary = OnBrandRed,
    primaryContainer = BrandRedLight,
    onPrimaryContainer = BrandRedDark,
    secondary = BrandRedDark,
    onSecondary = OnBrandRed,
    background = BackgroundWhite,
    onBackground = TextPrimary,
    surface = SurfaceWhite,
    onSurface = TextPrimary,
    surfaceVariant = FieldBackground,
    onSurfaceVariant = TextSecondary,
    error = ErrorRed,
    onError = OnBrandRed
)

@Composable
fun DashboardLoginTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}