package cypher.foodie.di

import androidx.compose.runtime.mutableStateListOf
import cypher.foodie.ui.components.models.Screen

object AppNavigator {
    private val _backStack = mutableStateListOf<Screen>(Screen.WelcomeScreen)

    val backStack: List<Screen>
        get() = _backStack

    val currentScreen: Screen?
        get() = _backStack.lastOrNull()

    fun navigateTo(screen: Screen, clearStack: Boolean = false) {
        if (clearStack) {
            _backStack.clear()
        }
        _backStack.add(screen)
    }

    fun goBack() {
        _backStack.removeLastOrNull()
    }
}