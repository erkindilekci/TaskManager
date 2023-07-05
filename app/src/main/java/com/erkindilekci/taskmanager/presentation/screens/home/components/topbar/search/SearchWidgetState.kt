package com.erkindilekci.taskmanager.presentation.screens.home.components.topbar.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.erkindilekci.taskmanager.presentation.components.widget.WidgetState
import com.erkindilekci.taskmanager.presentation.components.widget.WidgetValue
import com.erkindilekci.taskmanager.presentation.screens.home.HomeViewModel

sealed interface SearchWidgetState : WidgetState {
    var searchQuery: String
    fun onSearchQueryChange(query: String)
}

class SearchWidgetStateImpl(
    private val homeViewModel: HomeViewModel
) : SearchWidgetState {

    override var searchQuery: String by mutableStateOf("")
    override val isVisible: Boolean get() = _currentWidgetValueState.value != WidgetValue.Closed

    private val _currentWidgetValueState: MutableState<WidgetValue> =
        mutableStateOf(WidgetValue.Closed)

    override fun onSearchQueryChange(query: String) {
        searchQuery = query
        homeViewModel.onSearchQueryChange(query)
    }

    override fun openWidget() {
        _currentWidgetValueState.value = WidgetValue.Opened
    }

    override fun closeWidget() {
        _currentWidgetValueState.value = WidgetValue.Closed
    }
}

@Composable
fun rememberSearchWidgetState(
    homeViewModel: HomeViewModel = hiltViewModel()
) = remember {
    SearchWidgetStateImpl(homeViewModel = homeViewModel)
}
