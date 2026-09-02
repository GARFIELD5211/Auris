/*
    Auris - AirPods companion for Android
    Copyright (C) 2025 Auris contributors

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

@file:OptIn(ExperimentalEncodingApi::class)

package me.kavishdevar.aurix.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import me.auris.app.R
import kotlin.io.encoding.ExperimentalEncodingApi

@Composable
fun ConnectionSettings(
    automaticEarDetectionEnabled: Boolean,
    onAutomaticEarDetectionChanged: (Boolean) -> Unit,
    automaticConnectionEnabled: Boolean,
    onAutomaticConnectionChanged: (Boolean) -> Unit,
) {
    StyledList {
        StyledToggle(
            label = stringResource(R.string.ear_detection),
            checked = automaticEarDetectionEnabled,
            onCheckedChange = onAutomaticEarDetectionChanged
        )

        StyledToggle(
            label = stringResource(R.string.automatically_connect),
            description = stringResource(R.string.automatically_connect_description),
            checked = automaticConnectionEnabled,
            onCheckedChange = onAutomaticConnectionChanged
        )
    }
}
