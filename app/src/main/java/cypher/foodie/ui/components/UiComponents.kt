package cypher.foodie.ui.components

import android.graphics.text.MeasuredText
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.R
import cypher.foodie.ui.components.models.ErrorLayoutButton
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography


@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    rightNavButton: @Composable () -> Unit = {},
    onBackClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.large)
            .height(60.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        ToolbarNavButton(icon = R.drawable.ic_back) { }
        Text(
            text = stringResource(title),
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 18.sp,
            style = MaterialTheme.textTypography.textSemiBold,
            modifier = Modifier.weight(1f)
        )
        ToolbarNavButton(icon = R.drawable.ic_heart) { }
    }
}

@Composable
fun ToolbarNavButton(modifier: Modifier = Modifier, @DrawableRes icon: Int, onClick: () -> Unit) {
    Image(painter = painterResource(icon), contentDescription = "", modifier = modifier.clickable {
        onClick()
    })
}

@Composable
fun ElevatedCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Box(
            Modifier
                .padding(MaterialTheme.spacing.large), contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
fun BigButton(
    modifier: Modifier = Modifier,
    isPrimaryButton: Boolean = true,
    @StringRes text: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = MaterialTheme.spacing.extraLarge)
                .height(70.dp)
                .background(Color.Transparent),
            onClick = onClick,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = if (isPrimaryButton) MaterialTheme.colorScheme.primary else Color.White)
        ) {
            Text(
                text = stringResource(text),
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isPrimaryButton) Color.White else MaterialTheme.colorScheme.primary,
                style = MaterialTheme.textTypography.textSemiBold
            )
        }
    }
}

@Composable
fun ErrorLayout(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes title: Int,
    @StringRes subtitle: Int,
    buttonData: ErrorLayoutButton
) {
    val shouldShowButton = buttonData.showButton
    val isPrimaryCTA = buttonData.isPrimaryCTA

    Box(
        modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp)
        ) {
            Image(modifier = Modifier.size(110.dp), contentDescription = null, painter = painterResource(image))
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            Text(
                text = stringResource(title),
                style = MaterialTheme.textTypography.textSemiBold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            Text(
                text = stringResource(subtitle),
                style = MaterialTheme.textTypography.textRegular,
                textAlign = TextAlign.Center
            )
            if (shouldShowButton && isPrimaryCTA.not()) {
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
                BigButton(text = buttonData.text, isPrimaryButton = true) { buttonData.onClick() }
            }
        }

        if (shouldShowButton && isPrimaryCTA) {
            BigButton(
                modifier = Modifier.align(Alignment.BottomCenter),
                text = buttonData.text,
                isPrimaryButton = true
            ) { buttonData.onClick() }
        }

    }
}

@Composable
fun MenuListItem(
    modifier: Modifier = Modifier,
    applyPadding: Boolean = false,
    @StringRes title: Int,
    @StringRes price: Int,
    @DrawableRes image: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .padding(top = if (applyPadding) MaterialTheme.spacing.extraLarge else 0.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier
                .width(210.dp)
                .height(270.dp)
                .padding(top = 40.dp),
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = MaterialTheme.spacing.medium)
        ) {
            Column(
                modifier = Modifier
                    .padding(MaterialTheme.spacing.extraLarge)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = stringResource(title), textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 22.sp,
                    style = MaterialTheme.roundedTypography.roundedSemiBold
                )
                Spacer(Modifier.height(MaterialTheme.spacing.large))
                Text(
                    text = stringResource(price),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 17.sp,
                    style = MaterialTheme.roundedTypography.roundedBold
                )
            }
        }
        Image(
            painter = painterResource(image), contentDescription = null, modifier = Modifier
                .size(120.dp)
                .clip(
                    CircleShape
                )
        )
    }
}


@Composable
fun FoodieBottomNavigation(modifier: Modifier = Modifier, selectedIndex: Int, onClick: (Int) -> Unit) {
    val tabItems = listOf(
        TabItem(Icons.Outlined.Home, Icons.Filled.Home),
        TabItem(Icons.Outlined.FavoriteBorder, Icons.Outlined.FavoriteBorder),
        TabItem(Icons.Outlined.Person, Icons.Outlined.Person),
        TabItem(Icons.Outlined.Refresh, Icons.Outlined.Refresh)
    )
    BottomAppBar(
        modifier = modifier
            .fillMaxWidth(), containerColor = Color.Transparent
    ) {
        tabItems.forEachIndexed { index, item ->
            val isSelected = index == selectedIndex
            IconButton(onClick = { onClick(index) }, modifier = Modifier.weight(1f)) {
                Icon(
                    imageVector = item.getIcon(isSelected),
                    contentDescription = "BottomNav",
                    tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                    modifier = Modifier
                        .size(32.dp)
                        .shadow(
                            elevation = if (isSelected) 0.dp else 0.dp,
                            shape = CircleShape,
                            clip = true,
                            spotColor = MaterialTheme.colorScheme.primary
                        )
                )
            }
        }
    }
}

/*
@Preview
@Composable
private fun FoodieBottomNavPreview() {
    FoodieTheme {
        FoodieBottomNavigation(selectedIndex = 0, onClick = {})
    }
}
*/

data class TabItem(val defaultIcon: ImageVector, val selectedIcon: ImageVector) {
    fun getIcon(isSelected: Boolean): ImageVector {
        return if (isSelected) selectedIcon else defaultIcon
    }
}


@Preview
@Composable
private fun MenuListItemPreview() {
    FoodieTheme {
        Box(modifier = Modifier.background(Color.White)) {
            MenuListItem(
                modifier = Modifier.padding(all = MaterialTheme.spacing.extraLarge),
                title = R.string.item_name_moi_koi,
                price = R.string.price_1,
                image = R.drawable.img_fried_chicken_mix
            ) { }

        }
    }
}

/*
@Preview
@Composable
private fun ToolbarPreview() {
    FoodieTheme {
        Toolbar(modifier = Modifier.background(Color.White), title = R.string.my_profile, onBackClick = {})
    }
}


@Preview
@Composable
private fun BigButtonPreview(darkTheme: Boolean = false) {
    FoodieTheme {
        Column {
            BigButton(text = R.string.update_profile, isPrimaryButton = true) {}
            BigButton(text = R.string.update_profile, isPrimaryButton = false) {}
        }
    }
}


@Preview
@Composable
private fun ElevatedCardPreview() {
    FoodieTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            ElevatedCard(
                Modifier.padding(MaterialTheme.spacing.medium)
            ) { Text("Something in the waySomething in the waySomething in the waySomething in the waySomething in the waySomething in the way") }
        }

    }
}

@Preview
@Composable
private fun ErrorLayoutPrimary() {
    FoodieTheme {
        ErrorLayout(
            modifier = Modifier.background(Color.White),
            image = R.drawable.error_no_connection,
            title = R.string.error_title_no_network,
            subtitle = R.string.error_subtitle_no_network,
            buttonData = ErrorLayoutButton(isPrimaryCTA = true, text = R.string.start_ordering, showButton = true)
        )
    }
}

@Preview
@Composable
private fun ErrorLayoutNonPrimary() {
    FoodieTheme {
        ErrorLayout(
            modifier = Modifier.background(Color.White),
            image = R.drawable.error_no_connection,
            title = R.string.error_title_no_network,
            subtitle = R.string.error_subtitle_no_network,
            buttonData = ErrorLayoutButton(isPrimaryCTA = false, text = R.string.try_again, showButton = true)
        )

    }
}

@Preview
@Composable
private fun ErrorLayoutNoButton() {
    FoodieTheme {
        ErrorLayout(
            modifier = Modifier.background(Color.White),
            image = R.drawable.error_no_connection,
            title = R.string.error_title_no_network,
            subtitle = R.string.error_subtitle_no_network,
            buttonData = ErrorLayoutButton()
        )
    }
}
*/



