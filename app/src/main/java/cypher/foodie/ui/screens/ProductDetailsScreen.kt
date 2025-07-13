package cypher.foodie.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import cypher.foodie.ui.components.BigButton
import cypher.foodie.ui.components.FoodMenuDetails
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.components.models.Screen
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography
import kotlinx.coroutines.launch


@Composable
fun ProductDetailsScreen(modifier: Modifier = Modifier, productDetails: FoodMenuDetails) {
    val images = listOf(
        R.drawable.img_fried_chicken_mix,
        R.drawable.img_moi_koi,
        R.drawable.img_veggie_tomato_mix,
        R.drawable.img_egg_cucumber
    )
    val initialPage = images.indexOfFirst {
        it == productDetails.image
    }
    val pagerState = rememberPagerState(initialPage = initialPage, pageCount = { images.size })
    val coroutineScope = rememberCoroutineScope()
    Scaffold(modifier = modifier, topBar = {
        Toolbar(
            modifier = Modifier,
            title = R.string.blank,
            onBackClick = { AppNavigator.goBack() },
            rightNavIcon = R.drawable.ic_cart,
            rightNavAction = { AppNavigator.navigateTo(Screen.CartScreen) })
    }, bottomBar = {
        BigButton(text = R.string.add_to_cart) { }
    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier, contentAlignment = Alignment.BottomCenter) {
                HorizontalPager(modifier = Modifier, state = pagerState) { index ->
                    PagerImageItem(modifier = Modifier, image = images[index])
                }
                Row(
                    modifier = Modifier.padding(bottom = MaterialTheme.spacing.medium),
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
                ) {
                    images.forEachIndexed { index, _ ->
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .clickable {
                                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                                }
                                .background(if (index == pagerState.currentPage) MaterialTheme.colorScheme.primary else Color.LightGray)
                        )
                    }
                }
            }

            Text(
                text = stringResource(productDetails.title),
                style = MaterialTheme.roundedTypography.roundedSemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier, fontSize = 28.sp
            )
            Spacer(Modifier.height(MaterialTheme.spacing.small))
            Text(
                text = stringResource(productDetails.price),
                style = MaterialTheme.roundedTypography.roundedBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier, fontSize = 22.sp
            )
            Spacer(Modifier.height(MaterialTheme.spacing.xxLarge))
            DescriptionText(
                modifier = Modifier,
                title = R.string.delivery_info,
                description = productDetails.deliveryInfo
            )
            Spacer(Modifier.height(MaterialTheme.spacing.extraLarge))
            DescriptionText(
                modifier = Modifier,
                title = R.string.return_policy,
                description = productDetails.returnPolicy
            )
        }
    }
}

@Composable
fun DescriptionText(modifier: Modifier = Modifier, title: Int, description: Int) {
    Column(
        modifier = modifier.padding(horizontal = MaterialTheme.spacing.extraLarge),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.roundedTypography.roundedSemiBold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier, fontSize = 16.sp
        )
        Spacer(Modifier.height(MaterialTheme.spacing.small))
        Text(
            text = stringResource(description),
            style = MaterialTheme.textTypography.textRegular,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            modifier = Modifier, fontSize = 14.sp
        )
    }
}

@Composable
fun PagerImageItem(modifier: Modifier = Modifier, @DrawableRes image: Int) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp), contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(image), contentDescription = "image", modifier = Modifier.size(180.dp).clip(CircleShape))
    }
}

@Preview
@Composable
private fun ProductDetailsScreenPreview() {
    FoodieTheme {
        ProductDetailsScreen(
            productDetails = FoodMenuDetails(
                title = R.string.item_name_egg_cucumber,
                price = R.string.price_1,
                image = R.drawable.img_egg_cucumber,
                deliveryInfo = R.string.delivery_info_details,
                returnPolicy = R.string.return_policy_details
            )
        )
    }
}