package cypher.foodie.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.R
import cypher.foodie.di.AppNavigator
import cypher.foodie.ui.components.AppConstants.cartList
import cypher.foodie.ui.components.BigButton
import cypher.foodie.ui.components.CartItemData
import cypher.foodie.ui.components.ElevatedCardView
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.components.models.Screen
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography

@Composable
fun CartScreen(modifier: Modifier = Modifier) {
    var cartListData by rememberSaveable { mutableStateOf(cartList) }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Toolbar(
            modifier = Modifier,
            title = R.string.cart,
            rightNavIcon = R.drawable.ic_heart,
            rightNavAction = { AppNavigator.navigateTo(Screen.WishListScreen()) },
            onBackClick = { AppNavigator.goBack() })
        Text(
            text = stringResource(R.string.swipe_to_delete),
            style = MaterialTheme.textTypography.textRegular,
            fontSize = 10.sp, modifier = Modifier.padding(vertical = MaterialTheme.spacing.large)
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.extraLarge),
            verticalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.large
            )
        ) {
            items(cartListData) { cartItem ->
                CartItem(modifier = Modifier, cartItemData = cartItem, onQuantityChanged = { isAdding ->
                    if (isAdding) {
                        cartListData = cartListData.map {
                            if (it.title == cartItem.title) {
                                it.copy(quantity = it.quantity + 1)
                            } else {
                                it
                            }
                        }.filter { it.quantity > 0 }
                    }
                })
            }
        }
        BigButton(text = R.string.checkout) {
            AppNavigator.navigateTo(Screen.CheckoutScreen)
        }
    }
}

@Composable
fun CartItem(modifier: Modifier = Modifier, cartItemData: CartItemData, onQuantityChanged: (Boolean) -> Unit) {
    ElevatedCardView(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { AppNavigator.navigateTo(Screen.ProductDetailsScreen(cartItemData.toFoodMenuDetails())) }
    ) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),
                contentDescription = "Cart item image",
                painter = painterResource(cartItemData.image)
            )
            Spacer(Modifier.width(MaterialTheme.spacing.large))
            Box(contentAlignment = Alignment.CenterStart) {
                Column {
                    Text(
                        text = stringResource(cartItemData.title),
                        style = MaterialTheme.roundedTypography.roundedSemiBold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier, fontSize = 16.sp
                    )
                    Spacer(Modifier.height(MaterialTheme.spacing.small))
                    Text(
                        text = stringResource(cartItemData.price),
                        style = MaterialTheme.roundedTypography.roundedSemiBold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier, fontSize = 14.sp
                    )
                }
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                    Counter(
                        Modifier,
                        value = cartItemData.quantity.toString(),
                        onAdd = { onQuantityChanged(true) },
                        onRemove = {
                            onQuantityChanged(false)
                        })
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier, value: String, onAdd: () -> Unit, onRemove: () -> Unit) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary, MaterialTheme.shapes.large)
            .height(25.dp)
            .clip(MaterialTheme.shapes.large)
            .padding(horizontal = MaterialTheme.spacing.extraSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall)
    ) {
        Icon(
            modifier = Modifier
                .size(18.dp)
                .clickable { onRemove() },
            tint = Color.White,
            painter = painterResource(R.drawable.ic_remove),
            contentDescription = ""
        )
        Text(
            text = value,
            color = Color.White,
            style = MaterialTheme.roundedTypography.roundedSemiBold,
            fontSize = 13.sp
        )
        Icon(
            painter = painterResource(R.drawable.ic_add), contentDescription = "",
            modifier = Modifier
                .size(16.dp)
                .clickable { onAdd() },
            tint = Color.White,
        )
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    FoodieTheme {
        CartScreen()
    }
}