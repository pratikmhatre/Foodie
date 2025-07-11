package cypher.foodie.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import cypher.foodie.R

data class MenuItem(@StringRes val title: Int, @StringRes val price: Int, @DrawableRes val image: Int)

object AppConstants {
    val menuList = listOf(
        MenuItem(R.string.item_name_fried_chicken, R.string.price_1, R.drawable.img_fried_chicken_mix),
        MenuItem(R.string.item_name_moi_koi, R.string.price_1, R.drawable.img_moi_koi),
        MenuItem(R.string.item_name_veggie_mix, R.string.price_1, R.drawable.img_veggie_tomato_mix),
        MenuItem(R.string.item_name_egg_cucumber, R.string.price_1, R.drawable.img_egg_cucumber),
    )
}