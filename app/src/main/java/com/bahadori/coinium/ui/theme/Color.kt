package com.bahadori.coinium.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF005CBC)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFD7E2FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001B3F)
val md_theme_light_secondary = Color(0xFF00639A)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFCEE5FF)
val md_theme_light_onSecondaryContainer = Color(0xFF001D32)
val md_theme_light_tertiary = Color(0xFF00696E)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFF6AF6FF)
val md_theme_light_onTertiaryContainer = Color(0xFF002022)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFF8FDFF)
val md_theme_light_onBackground = Color(0xFF001F25)
val md_theme_light_surface = Color(0xFFF8FDFF)
val md_theme_light_onSurface = Color(0xFF001F25)
val md_theme_light_surfaceVariant = Color(0xFFE0E2EC)
val md_theme_light_onSurfaceVariant = Color(0xFF44474E)
val md_theme_light_outline = Color(0xFF74777F)
val md_theme_light_inverseOnSurface = Color(0xFFD6F6FF)
val md_theme_light_inverseSurface = Color(0xFF00363F)
val md_theme_light_inversePrimary = Color(0xFFABC7FF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF005CBC)
val md_theme_light_outlineVariant = Color(0xFFC4C6D0)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFABC7FF)
val md_theme_dark_onPrimary = Color(0xFF002F66)
val md_theme_dark_primaryContainer = Color(0xFF002F38)
val md_theme_dark_onPrimaryContainer = Color(0xFFD7E2FF)
val md_theme_dark_secondary = Color(0xFF96CCFF)
val md_theme_dark_onSecondary = Color(0xFF003353)
val md_theme_dark_secondaryContainer = Color(0xFF004A76)
val md_theme_dark_onSecondaryContainer = Color(0xFFCEE5FF)
val md_theme_dark_tertiary = Color(0xFF00DCE6)
val md_theme_dark_onTertiary = Color(0xFF003739)
val md_theme_dark_tertiaryContainer = Color(0xFF004F53)
val md_theme_dark_onTertiaryContainer = Color(0xFF6AF6FF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF001F25)
val md_theme_dark_onBackground = Color(0xFFA6EEFF)
val md_theme_dark_surface = Color(0xFF001F25)
val md_theme_dark_onSurface = Color(0xFFA6EEFF)
val md_theme_dark_surfaceVariant = Color(0xFF44474E)
val md_theme_dark_onSurfaceVariant = Color(0xFFC4C6D0)
val md_theme_dark_outline = Color(0xFF8E9099)
val md_theme_dark_inverseOnSurface = Color(0xFF001F25)
val md_theme_dark_inverseSurface = Color(0xFFA6EEFF)
val md_theme_dark_inversePrimary = Color(0xFF005CBC)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFABC7FF)
val md_theme_dark_outlineVariant = Color(0xFF44474E)
val md_theme_dark_scrim = Color(0xFF000000)


val seed = Color(0xFF096FDF)

inline val ColorScheme.green: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFF297500) else Color(0xFF40CF0C)

inline val ColorScheme.red: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFF750000) else Color(0xFFCF0C0C)

inline val ColorScheme.title: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFF161616) else Color(0xFFDFDFDF)

inline val ColorScheme.reverseTitle: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color(0xFFDFDFDF) else Color(0xFF161616)