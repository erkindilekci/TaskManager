package com.erkindilekci.taskmanager.presentation.common.model

import androidx.compose.ui.graphics.Color
import com.erkindilekci.taskmanager.presentation.common.theme.LightHighPriorityColor
import com.erkindilekci.taskmanager.presentation.common.theme.DarkHighPriorityColor
import com.erkindilekci.taskmanager.presentation.common.theme.LightLowPriorityColor
import com.erkindilekci.taskmanager.presentation.common.theme.DarkLowPriorityColor
import com.erkindilekci.taskmanager.presentation.common.theme.LightMediumPriorityColor
import com.erkindilekci.taskmanager.presentation.common.theme.DarkMediumPriorityColor
import com.erkindilekci.taskmanager.presentation.common.theme.LightNonePriorityColor
import com.erkindilekci.taskmanager.presentation.common.theme.DarkNonePriorityColor

enum class PriorityView(val colorLight: Color, val colorDark: Color) {
    HIGH(DarkHighPriorityColor, LightHighPriorityColor),
    MEDIUM(DarkMediumPriorityColor, LightMediumPriorityColor),
    LOW(DarkLowPriorityColor, LightLowPriorityColor),
    NONE(DarkNonePriorityColor, LightNonePriorityColor)
}
