package com.erkindilekci.taskmanager.domain.usecases.format.date

interface FormatDateUseCase {

    operator fun invoke(date: String): String
}
