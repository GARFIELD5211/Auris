package me.kavishdevar.aurix.data.updates

import androidx.compose.runtime.Composable
import me.auris.app.R
import me.kavishdevar.aurix.presentation.screens.AirPodsSettingsScreenPreviewMaterial
import me.kavishdevar.aurix.presentation.screens.EqualizerScreenPreviewApple
import me.kavishdevar.aurix.presentation.screens.EqualizerScreenPreviewMaterial
import me.kavishdevar.aurix.presentation.theme.DesignSystem
import me.kavishdevar.aurix.presentation.theme.LocalDesignSystem

val update1_0_0 = listOf(
        UpdateItem(
            titleRes = R.string.material3e,
            descriptionRes = R.string.update_m3e_description,
            demoComposeable = @Composable {
                AirPodsSettingsScreenPreviewMaterial()
            }
        ),
        UpdateItem(
            titleRes = R.string.equalizer,
            descriptionRes = R.string.update_equalizer_description,
            demoComposeable = @Composable {
                when (LocalDesignSystem.current) {
                    DesignSystem.Apple -> {
                        EqualizerScreenPreviewApple()
                    }
                    DesignSystem.Material -> {
                        EqualizerScreenPreviewMaterial()
                    }
                }
            }
        ),
    )

val updates = update1_0_0
