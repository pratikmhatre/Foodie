package cypher.foodie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cypher.foodie.ui.screens.DashboardScreen
import cypher.foodie.ui.screens.OnboardingScreen
import cypher.foodie.ui.screens.WishlistScreen
import cypher.foodie.ui.theme.FoodieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodieTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WishlistScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    MaterialTheme.shapes.medium
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodieTheme {
        Greeting("Android")
    }
}