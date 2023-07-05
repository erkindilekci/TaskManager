package com.erkindilekci.taskmanager.domain.usecases.validate.input

import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.domain.providers.StringResourceProvider
import com.erkindilekci.taskmanager.util.TaskException
import javax.inject.Inject

class ValidateInputsUseCaseImpl @Inject constructor(
    private val stringResourceProvider: StringResourceProvider
) : ValidateInputsUseCase {

    override fun invoke(vararg inputs: String) {
        inputs.forEach { input ->
            if (input.isBlank()) {
                throw TaskException(stringResourceProvider.getString(R.string.enter_all_fields))
            }
        }
    }
}
