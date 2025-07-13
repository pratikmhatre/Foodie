package cypher.foodie.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Refresh
import cypher.foodie.R

data class FoodMenuItem(@StringRes val title: Int, @StringRes val price: Int, @DrawableRes val image: Int) {
    fun toProductDetails(): FoodMenuDetails {
        return FoodMenuDetails(
            title = title,
            image = image,
            deliveryInfo = R.string.delivery_info_details,
            returnPolicy = R.string.return_policy_details,
            price = price
        )
    }
}
data class CartItemData(
    @StringRes val title: Int,
    @StringRes val price: Int,
    @DrawableRes val image: Int,
    val quantity: Int,
    val isFavourite: Boolean = false
){
    fun toFoodMenuDetails(): FoodMenuDetails {
        return FoodMenuDetails(
            title = title,
            image = image,
            deliveryInfo = R.string.delivery_info_details,
            returnPolicy = R.string.return_policy_details, price = price)
    }
}

data class FoodMenuDetails(
    @StringRes val title: Int,
    @StringRes val price: Int,
    @DrawableRes val image: Int,
    @StringRes val deliveryInfo: Int,
    @StringRes val returnPolicy: Int
)

object AppConstants {
    val cartList = listOf(
        CartItemData(
            title = R.string.item_name_moi_koi,
            price = R.string.price_1,
            image = R.drawable.img_moi_koi,
            quantity = 1
        ),
        CartItemData(
            title = R.string.item_name_veggie_mix,
            price = R.string.price_2,
            image = R.drawable.img_fried_chicken_mix,
            quantity = 4
        ),
        CartItemData(
            title = R.string.item_name_moi_koi,
            price = R.string.price_1,
            image = R.drawable.img_moi_koi,
            quantity = 2
        ),
        CartItemData(
            title = R.string.item_name_moi_koi,
            price = R.string.price_1,
            image = R.drawable.img_moi_koi,
            quantity = 6
        ),
    )

    val menuList = listOf(
        FoodMenuItem(R.string.item_name_fried_chicken, R.string.price_1, R.drawable.img_fried_chicken_mix),
        FoodMenuItem(R.string.item_name_moi_koi, R.string.price_1, R.drawable.img_moi_koi),
        FoodMenuItem(R.string.item_name_veggie_mix, R.string.price_1, R.drawable.img_veggie_tomato_mix),
        FoodMenuItem(R.string.item_name_egg_cucumber, R.string.price_1, R.drawable.img_egg_cucumber),
    )

    val navBarTabs = listOf(
        TabItem(Icons.Outlined.Home, Icons.Filled.Home),
        TabItem(Icons.Outlined.FavoriteBorder, Icons.Outlined.FavoriteBorder),
        TabItem(Icons.Outlined.Person, Icons.Outlined.Person),
        TabItem(Icons.Outlined.Refresh, Icons.Outlined.Refresh)
    )
}