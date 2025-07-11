package cypher.foodie.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.R
import cypher.foodie.ui.components.AppConstants
import cypher.foodie.ui.components.FoodieBottomNavigation
import cypher.foodie.ui.components.MenuListItem
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography


private val tabs = listOf(
    R.string.food_entries,
    R.string.food_main_course,
    R.string.food_on_tap,
    R.string.food_break,
    R.string.food_desserts
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }
    var bottomNavPosition by rememberSaveable { mutableIntStateOf(0) }
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { tabs.size })

    LaunchedEffect(selectedTab) { pagerState.animateScrollToPage(selectedTab) }

    /*LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (pagerState.isScrollInProgress.not()) selectedTab = pagerState.currentPage
    }*/

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                modifier = Modifier,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                title = {},
                navigationIcon = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {}) {
                            Icon(painter = painterResource(R.drawable.ic_drawer), contentDescription = "Drawer")
                        }
                        IconButton(onClick = {}) {
                            Icon(painter = painterResource(R.drawable.ic_cart), contentDescription = "Drawer")
                        }
                    }
                })
        },
        bottomBar = {
            FoodieBottomNavigation(
                modifier = Modifier,
                selectedIndex = bottomNavPosition,
                onClick = { bottomNavPosition = it })
        },
        contentColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(vertical = MaterialTheme.spacing.extraLarge)
        ) {
            Text(
                text = stringResource(R.string.delicious_food_for_you),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 34.sp,
                style = MaterialTheme.roundedTypography.roundedBold,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraLarge)
            )
            Spacer(Modifier.height(MaterialTheme.spacing.xxLarge))
            SearchBar(
                hintText = R.string.search_food_menu,
                searchQuery = searchQuery,
                onTextChange = {},
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraLarge)
            )
            Spacer(Modifier.height(MaterialTheme.spacing.xxxLarge))

            ScrollableTabRow(selectedTabIndex = selectedTab, containerColor = Color.Transparent, divider = {}) {
                tabs.forEachIndexed { index, tab ->
                    val isSelected = index == selectedTab
                    Tab(
                        selected = isSelected,
                        text = {
                            Text(
                                stringResource(tab),
                                style = MaterialTheme.textTypography.textRegular,
                                fontSize = 17.sp
                            )
                        },
                        onClick = { selectedTab = index }, unselectedContentColor = Color(0xFF9A9A9D)
                    )
                }
            }
            HorizontalPager(state = pagerState, userScrollEnabled = false) {
                DashboardMenuList()
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    @StringRes hintText: Int,
    searchQuery: String,
    onTextChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(MaterialTheme.shapes.extraLarge)
            .background(Color(0xFFE7E4E4), shape = MaterialTheme.shapes.extraLarge)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MaterialTheme.spacing.extraLarge), horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(24.dp), tint = MaterialTheme.colorScheme.onBackground
            )
            TextField(
                value = searchQuery,
                onValueChange = onTextChange,
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text(
                        text = stringResource(hintText),
                        style = MaterialTheme.roundedTypography.roundedSemiBold,
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun DashboardMenuList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.spacing.extraLarge
        ), contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.extraLarge)
    ) {
        items(count = 10) { index ->
            val food = AppConstants.menuList.random()
            MenuListItem(title = food.title, price = food.price, image = food.image) { }
        }
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    FoodieTheme {
        DashboardScreen()
    }
}