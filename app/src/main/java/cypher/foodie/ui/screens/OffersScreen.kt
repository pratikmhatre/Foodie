package cypher.foodie.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cypher.foodie.R
import cypher.foodie.di.AppNavigator
import cypher.foodie.ui.components.ErrorLayout
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.components.models.Screen
import cypher.foodie.ui.theme.FoodieTheme

@Composable
fun OffersScreen(modifier: Modifier = Modifier, showNavIcons: Boolean = true) {
    Column(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        Toolbar(
            title = R.string.offers_and_coupons,
            onBackClick = { AppNavigator.goBack() },
            showNavIcons = showNavIcons, rightNavIcon = R.drawable.ic_heart, rightNavAction = {
                AppNavigator.navigateTo(
                    Screen.WishListScreen()
                )
            }
        )
        ErrorLayout(
            modifier = Modifier.weight(1f),
            title = R.string.error_no_offers,
            subtitle = R.string.error_no_offers_description
        )
    }
}

@Preview
@Composable
private fun OrdersScreenPreview() {
    FoodieTheme {
        OffersScreen()
    }
}