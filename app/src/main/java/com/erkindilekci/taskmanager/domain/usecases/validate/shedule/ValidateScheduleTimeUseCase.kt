package com.erkindilekci.taskmanager.domain.usecases.validate.shedule

import com.erkindilekci.taskmanager.domain.model.Status

interface ValidateScheduleTimeUseCase {

    operator fun invoke(time: String, date: String, status: Status): Long
}
