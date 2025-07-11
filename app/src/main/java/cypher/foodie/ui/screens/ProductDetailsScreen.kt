package cypher.foodie.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.R
import cypher.foodie.ui.components.BigButton
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography

data class FoodProductDetails(
    @StringRes val title: Int,
    @StringRes val price: Int,
    @DrawableRes val image: Int,
    @StringRes val deliveryInfo: Int,
    @StringRes val returnPolicy: Int
)

@Composable
fun ProductDetailsScreen(modifier: Modifier = Modifier) {
    val details = FoodProductDetails(
        title = R.string.item_name_egg_cucumber,
        price = R.string.price_1,
        image = R.drawable.img_egg_cucumber,
        deliveryInfo = R.string.delivery_info_details,
        returnPolicy = R.string.return_policy_details
    )

    val images = listOf(
        R.drawable.img_fried_chicken_mix,
        R.drawable.img_moi_koi,
        R.drawable.img_veggie_tomato_mix,
        R.drawable.img_egg_cucumber
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { images.size })
    Scaffold(modifier = modifier, topBar = {
        Toolbar(
            modifier = Modifier,
            title = R.string.blank,
            onBackClick = {}, rightNavIcon = R.drawable.ic_heart, rightNavAction = {})
    }, bottomBar = {
        BigButton(text = R.string.add_to_cart) { }
    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(modifier = Modifier, state = pagerState) { index ->
                PagerImageItem(modifier = Modifier, image = images[index])
            }
            /*TabRow(modifier = Modifier, selectedTabIndex = 0, containerColor = Color.Transparent) {

            }*/

            Text(
                text = stringResource(details.title),
                style = MaterialTheme.roundedTypography.roundedSemiBold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier, fontSize = 28.sp
            )
            Spacer(Modifier.height(MaterialTheme.spacing.small))
            Text(
                text = stringResource(details.price),
                style = MaterialTheme.roundedTypography.roundedBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier, fontSize = 22.sp
            )
            Spacer(Modifier.height(MaterialTheme.spacing.xxLarge))
            DescriptionText(
                modifier = Modifier,
                title = R.string.delivery_info,
                description = details.deliveryInfo
            )
            Spacer(Modifier.height(MaterialTheme.spacing.extraLarge))
            DescriptionText(
                modifier = Modifier,
                title = R.string.return_policy,
                description = details.returnPolicy
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
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier, fontSize = 16.sp
        )
        Spacer(Modifier.height(MaterialTheme.spacing.small))
        Text(
            text = stringResource(description),
            style = MaterialTheme.textTypography.textRegular,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
            modifier = Modifier, fontSize = 14.sp
        )
    }
}

@Composable
fun PagerImageItem(modifier: Modifier = Modifier, @DrawableRes image: Int) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(image), contentDescription = "image", modifier = Modifier.size(180.dp))
    }
}

@Preview
@Composable
private fun ProductDetailsScreenPreview() {
    FoodieTheme {
        ProductDetailsScreen()
    }
}