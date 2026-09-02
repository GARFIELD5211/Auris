package me.kavishdevar.aurix.presentation.theme

import androidx.compose.runtime.compositionLocalOf

enum class DesignSystem {
    Apple,
    Material
}

val LocalDesignSystem = compositionLocalOf {
    DesignSystem.Apple
}
