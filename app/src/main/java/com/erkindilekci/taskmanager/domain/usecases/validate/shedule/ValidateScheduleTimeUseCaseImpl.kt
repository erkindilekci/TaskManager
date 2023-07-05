package com.erkindilekci.taskmanager.domain.usecases.validate.shedule

import com.erkindilekci.taskmanager.R
import com.erkindilekci.taskmanager.domain.model.Status
import com.erkindilekci.taskmanager.domain.providers.StringResourceProvider
import com.erkindilekci.taskmanager.util.TaskException
import com.erkindilekci.taskmanager.util.Utils
import java.util.Calendar
import javax.inject.Inject

class ValidateScheduleTimeUseCaseImpl @Inject constructor(
    private val stringResourceProvider: StringResourceProvider
) : ValidateScheduleTimeUseCase {

    override fun invoke(time: String, date: String, status: Status): Long {
        val nowTime = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
        }
        val dueTime = Utils.convertStringToCalendar(date, time)

        val timeInMillisTask = dueTime.timeInMillis - nowTime.timeInMillis

        if (status == Status.TODO) {
            if (timeInMillisTask <= 0) {
                throw TaskException(stringResourceProvider.getString(R.string.enter_time_and_date_valid))
            }
        }

        return timeInMillisTask
    }
}
