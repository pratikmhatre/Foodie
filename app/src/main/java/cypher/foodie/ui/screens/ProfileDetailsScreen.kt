package cypher.foodie.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.R
import cypher.foodie.di.AppNavigator
import cypher.foodie.ui.components.ElevatedCardView
import cypher.foodie.ui.components.LargeSpacer
import cypher.foodie.ui.components.ProfileCard
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.components.models.Screen
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography


@Composable
fun ProfileDetailsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                start = MaterialTheme.spacing.extraLarge,
                end = MaterialTheme.spacing.extraLarge, bottom = 0.dp
            ), verticalArrangement = Arrangement.Top
    ) {
        Toolbar(title = R.string.my_profile, showNavIcons = false) { }
        Spacer(Modifier.height(MaterialTheme.spacing.xxLarge))
        ProfileCard()
        LargeSpacer()
        ProfileMenuItem(title = R.string.offers_and_coupons) { AppNavigator.navigateTo(Screen.OffersScreen) }
        LargeSpacer()
        ProfileMenuItem(title = R.string.orders) { AppNavigator.navigateTo(Screen.OrdersScreen(true)) }
        LargeSpacer()
        ProfileMenuItem(title = R.string.wishlist) {AppNavigator.navigateTo(Screen.WishListScreen()) }
        LargeSpacer()
        ProfileMenuItem(title = R.string.cart) { AppNavigator.navigateTo(Screen.CartScreen) }
        LargeSpacer()
        ProfileMenuItem(title = R.string.rating_n_review) { }
        LargeSpacer()

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text(
                text = stringResource(R.string.signout),
                fontSize = 14.sp,
                style = MaterialTheme.textTypography.textSemiBold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        LargeSpacer()
    }
}

@Composable
fun ProfileMenuItem(modifier: Modifier = Modifier, @StringRes title: Int, onClick: () -> Unit) {
    ElevatedCardView(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(title), style = MaterialTheme.textTypography.textSemiBold, fontSize = 17.sp)
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Next")
            }
        }
    }
}

@Preview
@Composable
private fun ProfileDetailsScreenPreview() {
    FoodieTheme {
        ProfileDetailsScreen()
    }
}