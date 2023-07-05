package com.erkindilekci.taskmanager.infrastructure.providers.string

import android.content.Context
import androidx.annotation.StringRes
import com.erkindilekci.taskmanager.domain.providers.StringResourceProvider
import javax.inject.Inject

class StringResourceProviderImpl @Inject constructor(
    private val context: Context
) : StringResourceProvider {

    override fun getString(@StringRes stringResId: Int): String {
        return context.getString(stringResId)
    }
}
