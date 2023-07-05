package com.erkindilekci.taskmanager.domain.usecases.format.time

interface FormatTimeUseCase {

    operator fun invoke(hour: Int, minute: Int): String
}
