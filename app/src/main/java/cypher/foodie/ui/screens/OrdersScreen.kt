package cypher.foodie.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cypher.foodie.R
import cypher.foodie.di.AppNavigator
import cypher.foodie.ui.components.ErrorLayout
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.components.models.ErrorLayoutButton
import cypher.foodie.ui.components.models.Screen
import cypher.foodie.ui.theme.FoodieTheme

@Composable
fun OrdersScreen(modifier: Modifier = Modifier, showNavIcons: Boolean = true) {
    Column(modifier = modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()) {
        Toolbar(
            title = R.string.orders,
            onBackClick = { AppNavigator.goBack() },
            rightNavAction = { AppNavigator.navigateTo(Screen.WishListScreen()) },
            rightNavIcon = R.drawable.ic_heart, showNavIcons = showNavIcons
        )

        ErrorLayout(
            modifier = Modifier.fillMaxSize(),
            image = R.drawable.img_error_history,
            title = R.string.error_no_orders,
            subtitle = R.string.error_no_orders_description,
            buttonData = ErrorLayoutButton(
                showButton = true,
                isPrimaryCTA = true,
                text = R.string.start_ordering,
                onClick = {
                    AppNavigator.navigateTo(Screen.MainTabsScreen, true)
                })
        )
    }
}

@Preview
@Composable
private fun OrdersScreenPreview() {
    FoodieTheme {
        OrdersScreen()
    }
}