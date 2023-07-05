package com.erkindilekci.taskmanager.presentation.components.widget

interface WidgetState {
    val isVisible: Boolean
    fun openWidget()
    fun closeWidget()
}
