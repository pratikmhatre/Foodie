package cypher.foodie.ui.components.models

import cypher.foodie.ui.components.FoodMenuDetails

sealed class Screen {
    class WishListScreen(val showNavIcons: Boolean = true) : Screen()
    object CartScreen : Screen()
    object CheckoutScreen : Screen()
    object OnboardingScreen : Screen()
    object WelcomeScreen : Screen()
    class ProductDetailsScreen(val productDetails: FoodMenuDetails) : Screen()
    object MainTabsScreen : Screen()
    object OffersScreen : Screen()
    class OrdersScreen(val showNavIcons: Boolean = true) : Screen()
}