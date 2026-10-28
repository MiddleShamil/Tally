package ru.abdullaev.tally.core.mvi.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.abdullaev.tally.core.mvi.EffectHandler
import ru.abdullaev.tally.core.mvi.UiEffect
import ru.abdullaev.tally.core.mvi.UiIntent
import ru.abdullaev.tally.core.mvi.UiState

@Composable
fun <S : UiState, I : UiIntent, E : UiEffect> BaseScreen(
    viewModel: BaseViewModel<S, I, E>,
    onEffect: suspend (E) -> Unit,
    content: @Composable (state: S, onIntent: (I) -> Unit) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    EffectHandler(viewModel.effect, onEffect = onEffect)

    content(state, viewModel::onIntent)
}