package cypher.foodie.ui.components.models

import androidx.annotation.StringRes

data class ErrorLayoutButton(
    val showButton: Boolean = false,
    val isPrimaryCTA: Boolean = true,
    @StringRes val text: Int = 0,
    val onClick: () -> Unit = {}
)