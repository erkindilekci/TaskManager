package com.erkindilekci.taskmanager.domain.usecases.format.time

class FormatTimeUseCaseImpl : FormatTimeUseCase {

    private val timePatternWithZerosCorrect = "%02d:%02d"

    override fun invoke(hour: Int, minute: Int): String {
        return String.format(timePatternWithZerosCorrect, hour, minute)
    }
}
