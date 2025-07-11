package cypher.foodie.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import cypher.foodie.ui.components.ElevatedCard
import cypher.foodie.ui.components.ProfileCard
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography


@Composable
fun ProfileDetailsScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier, bottomBar = {
        BigButton(text = R.string.checkout) { }
    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(
                    top = MaterialTheme.spacing.extraLarge,
                    start = MaterialTheme.spacing.extraLarge,
                    end = MaterialTheme.spacing.extraLarge
                )
        ) {
            Text(
                text = stringResource(R.string.my_profile),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 34.sp,
                style = MaterialTheme.roundedTypography.roundedBold,
                modifier = Modifier
            )
            Spacer(Modifier.height(MaterialTheme.spacing.xxLarge))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = stringResource(R.string.personal_details),
                    fontSize = 17.sp,
                    style = MaterialTheme.textTypography.textSemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = stringResource(R.string.change),
                    fontSize = 14.sp,
                    style = MaterialTheme.textTypography.textRegular,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(Modifier.height(MaterialTheme.spacing.small))
            ProfileCard()
            Spacer(Modifier.height(MaterialTheme.spacing.large))
            ProfileMenuItem(title = R.string.orders) { }
            Spacer(Modifier.height(MaterialTheme.spacing.large))
            ProfileMenuItem(title = R.string.faq) { }
            Spacer(Modifier.height(MaterialTheme.spacing.large))
            ProfileMenuItem(title = R.string.settings) { }
            Spacer(Modifier.height(MaterialTheme.spacing.large))
            ProfileMenuItem(title = R.string.rating_n_review) { }
        }
    }
}

@Composable
fun ProfileMenuItem(modifier: Modifier = Modifier, @StringRes title: Int, onClick: () -> Unit) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick }) {
        Row(
            modifier = Modifier
                .fillMaxWidth().height(30.dp).background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(title), style = MaterialTheme.textTypography.textSemiBold, fontSize = 17.sp)
            IconButton(onClick = { onClick() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Next")
            }
        }
    }
}

@Preview
@Composable
private fun ProfileDetailsScreenPreview() {
    FoodieTheme {
        ProfileDetailsScreen()
    }
}