package cypher.foodie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import cypher.foodie.di.AppNavigator
import cypher.foodie.ui.components.models.Screen
import cypher.foodie.ui.screens.CartScreen
import cypher.foodie.ui.screens.CheckoutScreen
import cypher.foodie.ui.screens.MainTabsScreen
import cypher.foodie.ui.screens.OffersScreen
import cypher.foodie.ui.screens.OnboardingScreen
import cypher.foodie.ui.screens.OrdersScreen
import cypher.foodie.ui.screens.ProductDetailsScreen
import cypher.foodie.ui.screens.WelcomeScreen
import cypher.foodie.ui.screens.WishlistScreen
import cypher.foodie.ui.theme.FoodieTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodieTheme {
                NavFrame(modifier = Modifier.fillMaxSize())
            }
        }
    }

    @Composable
    fun NavFrame(modifier: Modifier = Modifier) {
        NavDisplay(
            backStack = AppNavigator.backStack,
            modifier = modifier,
            onBack = { AppNavigator.goBack() },
            entryProvider = entryProvider {
                entry<Screen.WelcomeScreen> {
                    WelcomeScreen {
                        AppNavigator.navigateTo(Screen.OnboardingScreen)
                    }
                }
                entry<Screen.WishListScreen> { WishlistScreen(showNavIcons = it.showNavIcons) }
                entry<Screen.OnboardingScreen> { OnboardingScreen() }
                entry<Screen.MainTabsScreen> { MainTabsScreen() }
                entry<Screen.ProductDetailsScreen> { ProductDetailsScreen(productDetails = it.productDetails) }
                entry<Screen.CartScreen> { CartScreen() }
                entry<Screen.CheckoutScreen> { CheckoutScreen() }
                entry<Screen.OffersScreen> { OffersScreen() }
                entry<Screen.OrdersScreen> { OrdersScreen(showNavIcons = it.showNavIcons) }
            })
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodieTheme {
        Greeting("Android")
    }
}