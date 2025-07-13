package cypher.foodie.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cypher.foodie.R
import cypher.foodie.di.AppNavigator
import cypher.foodie.ui.components.AppConstants
import cypher.foodie.ui.components.FoodMenuItem
import cypher.foodie.ui.components.MenuListItem
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.components.models.Screen
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(modifier: Modifier = Modifier, showNavIcons: Boolean = true) {
    Column(modifier = modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()) {
        Toolbar(
            title = R.string.wishlist,
            showNavIcons = showNavIcons,
            onBackClick = { AppNavigator.goBack() }
        )
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(MaterialTheme.spacing.extraLarge),
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.extraLarge
            ),
            verticalItemSpacing = MaterialTheme.spacing.extraLarge
        ) {
            items(30) {
                val menuItem = AppConstants.menuList.random()
                MenuListItem(
                    title = menuItem.title,
                    price = menuItem.price,
                    image = menuItem.image,
                    applyPadding = (it % 2 != 0)
                ) {
                    openDetailsFragment(menuItem)
                }
            }
        }

    }
}

private fun openDetailsFragment(menuItem: FoodMenuItem) {
    AppNavigator.navigateTo(Screen.ProductDetailsScreen(menuItem.toProductDetails()))
}

@Preview
@Composable
private fun WishlistScreenPreview() {
    FoodieTheme {
        WishlistScreen()
    }
}
