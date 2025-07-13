package cypher.foodie.ui.screens

import androidx.annotation.StringRes
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.R
import cypher.foodie.di.AppNavigator
import cypher.foodie.ui.components.BigButton
import cypher.foodie.ui.components.ElevatedCardView
import cypher.foodie.ui.components.ExtraLargeSpacer
import cypher.foodie.ui.components.LargeSpacer
import cypher.foodie.ui.components.MediumSpacer
import cypher.foodie.ui.components.SmallSpacer
import cypher.foodie.ui.components.Toolbar
import cypher.foodie.ui.components.XXLargeSpacer
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography

@Composable
fun CheckoutScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier, topBar = {
        Toolbar(
            modifier = Modifier,
            title = R.string.checkout,
            onBackClick = { AppNavigator.goBack() })
    }, bottomBar = {
        BigButton(text = R.string.continue_to_pay) { }
    }) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = MaterialTheme.spacing.extraLarge)
                .fillMaxSize(), horizontalAlignment = Alignment.Start
        ) {
            ExtraLargeSpacer()
            ProfileSection()
            XXLargeSpacer()
            DeliverySection()
            XXLargeSpacer()
            PaymentSection()
        }
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            SectionTitleText(text = R.string.personal_details)
            Text(
                modifier = Modifier.clickable {
                    showAddressDialog()
                },
                text = stringResource(R.string.change),
                fontSize = 14.sp,
                style = MaterialTheme.textTypography.textRegular,
                color = MaterialTheme.colorScheme.primary
            )
        }

        MediumSpacer()
        ElevatedCardView {
            Column(modifier = Modifier) {
                Text(
                    text = stringResource(R.string.users_name),
                    style = MaterialTheme.textTypography.textMedium,
                    fontSize = 16.sp
                )
                HorizontalDivider(
                    Modifier
                        .height(0.1.dp)
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .background(
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                )
                ExtraLargeSpacer()
                Text(
                    text = stringResource(R.string.users_phone),
                    style = MaterialTheme.textTypography.textRegular,
                    fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface
                )
                HorizontalDivider(
                    Modifier
                        .height(0.1.dp)
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .background(
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                )
                ExtraLargeSpacer()
                Text(
                    text = stringResource(R.string.users_address),
                    style = MaterialTheme.textTypography.textRegular,
                    fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface
                )

            }
        }
    }
}

private fun showAddressDialog() {

}

@Composable
fun AddressDialog(modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inverseOnSurface),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.extraLarge)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(start = MaterialTheme.spacing.xxLarge)
                    .clip(
                        RoundedCornerShape(
                            topStart = MaterialTheme.spacing.large,
                            topEnd = MaterialTheme.spacing.large
                        )
                    ), contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = stringResource(R.string.choose_profile),
                    style = MaterialTheme.textTypography.textMedium,
                    fontSize = 18.sp
                )
            }
            ExtraLargeSpacer()
            Column(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraLarge)) {
                Text(
                    "Delivery to David Parker".uppercase(),
                    style = MaterialTheme.textTypography.textMedium,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                )
                SmallSpacer()
                Row {
                    Text(
                        "3.5km",
                        style = MaterialTheme.textTypography.textRegular,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(Modifier.width(MaterialTheme.spacing.medium))
                    Text(
                        "30 min",
                        style = MaterialTheme.textTypography.textRegular,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            HorizontalDivider(
                Modifier
                    .height(0.1.dp)
                    .fillMaxWidth()
                    .padding(
                        top = MaterialTheme.spacing.large,
                        start = MaterialTheme.spacing.extraLarge,
                        end = MaterialTheme.spacing.extraLarge
                    )
                    .background(
                        MaterialTheme.colorScheme.onSurface
                    )
            )

            XXLargeSpacer()

            Column(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraLarge)) {
                Text(
                    "Delivery to David Parker".uppercase(),
                    style = MaterialTheme.textTypography.textMedium,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                )
                SmallSpacer()
                Row {
                    Text(
                        "1km",
                        style = MaterialTheme.textTypography.textRegular,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(Modifier.width(MaterialTheme.spacing.medium))
                    Text(
                        "10 min",
                        style = MaterialTheme.textTypography.textRegular,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = MaterialTheme.spacing.extraLarge)
        ) {

            Text(
                modifier = Modifier,
                text = stringResource(R.string.cancel),
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black.copy(alpha = 0.5f),
                style = MaterialTheme.textTypography.textSemiBold
            )
            Spacer(Modifier.width(50.dp))
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .background(Color.Transparent)
                    .weight(1f),
                onClick = {},
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = stringResource(R.string.proceed),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.inverseOnSurface,
                    style = MaterialTheme.textTypography.textSemiBold
                )
            }

        }
    }
}

@Composable
fun SectionTitleText(modifier: Modifier = Modifier, @StringRes text: Int) {
    Text(
        modifier = modifier,
        text = stringResource(text),
        style = MaterialTheme.textTypography.textSemiBold,
        fontSize = 17.sp, color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
fun DeliverySection(modifier: Modifier = Modifier) {
    Column(modifier) {
        SectionTitleText(text = R.string.delivery_method)
        MediumSpacer()
        ElevatedCardView {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    RadioButton(selected = true, onClick = {}, modifier = Modifier)
                    Text(
                        text = stringResource(R.string.door_delivery),
                        style = MaterialTheme.textTypography.textRegular, fontSize = 15.sp
                    )
                }
                HorizontalDivider(
                    Modifier
                        .height(0.1.dp)
                        .fillMaxWidth()
                        .padding(top = MaterialTheme.spacing.small, start = 50.dp)
                        .background(
                            MaterialTheme.colorScheme.onSurface
                        )
                )

                LargeSpacer()
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    RadioButton(selected = false, onClick = {}, modifier = Modifier)
                    Text(
                        text = stringResource(R.string.store_pickup),
                        style = MaterialTheme.textTypography.textRegular, fontSize = 15.sp
                    )
                }
            }
        }
    }
}

@Composable
fun PaymentSection(modifier: Modifier = Modifier) {
    Column(modifier) {
        SectionTitleText(text = R.string.payment_methods)
        MediumSpacer()
        ElevatedCardView {
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

@Preview
@Composable
private fun CheckoutScreenPreview() {
    FoodieTheme {
        ProfileSection(Modifier)
    }
}