package com.erkindilekci.taskmanager.domain.providers

interface StringResourceProvider {

    fun getString(stringResId: Int): String
}
