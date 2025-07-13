package cypher.foodie.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import cypher.foodie.ui.components.BigButton
import cypher.foodie.ui.components.ElevatedCardView
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier, containerColor = MaterialTheme.colorScheme.background,
        topBar = { Toolbar(modifier = Modifier, title = R.string.my_profile) { } }, bottomBar = {
            BigButton(text = R.string.update_profile, isPrimaryButton = true) {

            }
        }) { innerPadding ->
        Box(
            Modifier
                .padding(innerPadding)
                .padding(all = MaterialTheme.spacing.extraLarge), contentAlignment = Alignment.TopCenter
        ) {
            Column {
                Column {
                    Text(
                        text = stringResource(R.string.profile_information),
                        style = MaterialTheme.textTypography.textSemiBold,
                        fontSize = 17.sp
                    )
                    Spacer(Modifier.height(MaterialTheme.spacing.large))
                    ElevatedCardView {
                        Row(verticalAlignment = Alignment.Top, modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painter = painterResource(R.drawable.img_profile_avatar),
                                modifier = Modifier.size(60.dp),
                                contentDescription = "Profile Avatar"
                            )
                            Spacer(Modifier.width(MaterialTheme.spacing.medium))
                            Column(modifier = Modifier) {
                                Text(
                                    text = stringResource(R.string.users_name),
                                    style = MaterialTheme.textTypography.textSemiBold,
                                    fontSize = 18.sp
                                )
                                Spacer(Modifier.height(MaterialTheme.spacing.small))
                                Text(
                                    text = stringResource(R.string.users_email),
                                    style = MaterialTheme.textTypography.textRegular,
                                    fontSize = 13.sp, color = Color.LightGray
                                )
                                Spacer(Modifier.height(MaterialTheme.spacing.small))
                                Text(
                                    text = stringResource(R.string.users_address),
                                    style = MaterialTheme.textTypography.textRegular,
                                    fontSize = 14.sp, color = Color.LightGray
                                )

                            }
                        }
                    }
                }
                Spacer(Modifier.height(MaterialTheme.spacing.xxLarge))

                Column {
                    Text(
                        text = stringResource(R.string.payment_methods),
                        style = MaterialTheme.textTypography.textSemiBold,
                        fontSize = 17.sp
                    )
                    Spacer(Modifier.height(MaterialTheme.spacing.large))
                    ElevatedCardView(Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier) {
                            PaymentItem(
                                icon = R.drawable.ic_credit_card,
                                text = R.string.credit_card,
                                bgColor = Color(0xFFF47B0A)
                            )
                            PaymentItem(
                                icon = R.drawable.ic_bank,
                                text = R.string.bank_account,
                                bgColor = Color(0xFFEB4796)
                            )
                            PaymentItem(
                                icon = R.drawable.ic_paypal,
                                text = R.string.paypal,
                                bgColor = Color(0xFF0038FF), isLastItem = true
                            )
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun PaymentItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    @StringRes text: Int,
    bgColor: Color,
    isLastItem: Boolean = false
) {
    Column(modifier = modifier.padding(vertical = MaterialTheme.spacing.small)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(MaterialTheme.shapes.small)
                    .background(bgColor)
            ) {
                Image(
                    painter = painterResource(icon),
                    modifier = Modifier
                        .size(60.dp)
                        .padding(MaterialTheme.spacing.medium),
                    contentDescription = stringResource(text)
                )
            }
            Spacer(Modifier.width(MaterialTheme.spacing.medium))
            Text(
                text = stringResource(text),
                style = MaterialTheme.textTypography.textRegular,
                fontSize = 15.sp
            )
        }
        if (isLastItem.not()) {
            Spacer(Modifier.height(MaterialTheme.spacing.medium))
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(0.2.dp)
                    .padding(start = 50.dp)
                    .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))
            )
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    FoodieTheme { ProfileScreen() }
}