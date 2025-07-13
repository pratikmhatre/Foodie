package cypher.foodie.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cypher.foodie.ui.components.AppConstants.navBarTabs
import cypher.foodie.ui.components.FoodieBottomNavigation
import cypher.foodie.ui.theme.FoodieTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTabsScreen(modifier: Modifier = Modifier) {
    var bottomNavPosition by rememberSaveable { mutableIntStateOf(0) }
    var pagerState = rememberPagerState(initialPage = 0, pageCount = { navBarTabs.size })
    LaunchedEffect(bottomNavPosition) { pagerState.animateScrollToPage(bottomNavPosition) }
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Bottom
        ) {
            HorizontalPager(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(), state = pagerState, userScrollEnabled = false
            ) {
                Box(modifier = Modifier) {
                    GetScreenByPosition(it)
                }
            }
            FoodieBottomNavigation(
                modifier = Modifier,
                selectedIndex = bottomNavPosition,
                onClick = { bottomNavPosition = it })
        }

}

@Composable
private fun GetScreenByPosition(position: Int) {
    return when (position) {
        0 -> {
            HomeScreen()
        }

        1 -> {
            WishlistScreen(showNavIcons = false)
        }

        2 -> {
            ProfileDetailsScreen()
        }

        else -> {
            OffersScreen(showNavIcons = false)
        }
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    FoodieTheme {
        MainTabsScreen()
    }
}