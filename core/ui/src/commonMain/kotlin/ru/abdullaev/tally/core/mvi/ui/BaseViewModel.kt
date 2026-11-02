package ru.abdullaev.tally.core.mvi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.abdullaev.tally.core.mvi.UiEffect
import ru.abdullaev.tally.core.mvi.UiIntent
import ru.abdullaev.tally.core.mvi.UiState

abstract class BaseViewModel<S : UiState, I : UiIntent, E : UiEffect>(
    initialState: S,
) : ViewModel() {
    private val logger = Logger.withTag(this::class.simpleName ?: "BaseViewModel")

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state.asStateFlow()

    private val _effect = Channel<E>(Channel.BUFFERED)
    val effect: Flow<E> = _effect.receiveAsFlow()

    protected val currentState: S
        get() = _state.value

    fun onIntent(intent: I) {
        logger.d { "Intent: $intent" }
        handleIntent(intent)
    }

    protected abstract fun handleIntent(intent: I)

    protected fun updateState(reducer: (S) -> S) {
        _state.update(reducer)
    }

    protected fun sendEffect(effect: E) {
        logger.d { "Effect: $effect" }
        _effect.trySend(effect)
    }

    protected fun launchSafe(
        onError: (Throwable) -> Unit = ::handleError,
        block: suspend CoroutineScope.() -> Unit,
    ): Job =
        viewModelScope.launch(
            context =
                CoroutineExceptionHandler { _, throwable ->
                    logger.e(throwable) { "Unhandled error in coroutine" }
                    onError(throwable)
                },
            block = block,
        )

    protected open fun handleError(throwable: Throwable) = Unit
}
