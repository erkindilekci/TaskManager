package com.erkindilekci.taskmanager.domain.usecases.validate.input

interface ValidateInputsUseCase {

    operator fun invoke(vararg inputs: String)
}
