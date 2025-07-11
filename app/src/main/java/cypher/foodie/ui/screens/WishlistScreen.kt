package cypher.foodie.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.ui.components.AppConstants
import cypher.foodie.ui.components.MenuListItem
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(), containerColor = MaterialTheme.colorScheme.background, topBar = {
        TopAppBar(modifier = Modifier.height(70.dp), title = {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(
                    text = "Found Results",
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    style = MaterialTheme.roundedTypography.roundedBold
                )
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent))
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier,
                contentPadding = PaddingValues(all = MaterialTheme.spacing.extraLarge),
                horizontalArrangement = Arrangement.spacedBy(
                    MaterialTheme.spacing.extraLarge
                ),
                verticalItemSpacing = MaterialTheme.spacing.extraLarge
            ) {
                items(30) {
                    val menuList = AppConstants.menuList.random()
                    MenuListItem(
                        title = menuList.title,
                        price = menuList.price,
                        image = menuList.image,
                        applyPadding = (it % 2 != 0)
                    ) {}
                }
            }
        }
    }
}

@Preview
@Composable
private fun WishlistScreenPreview() {
    FoodieTheme {
        WishlistScreen()
    }
}