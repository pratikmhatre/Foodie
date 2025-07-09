package cypher.foodie.ui.components

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography


@Composable
fun ElevatedCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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
fun BigButton(modifier: Modifier = Modifier, isPrimaryButton: Boolean = true, text: String, onClick: () -> Unit) {
    Box(
        modifier = modifier.background(Color.White), contentAlignment = Alignment.Center
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
                text = text,
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
                BigButton(text = stringResource(buttonData.text), isPrimaryButton = true) { buttonData.onClick() }
            }
        }

        if (shouldShowButton && isPrimaryCTA) {
            BigButton(
                modifier = Modifier.align(Alignment.BottomCenter),
                text = stringResource(buttonData.text),
                isPrimaryButton = true
            ) { buttonData.onClick() }
        }
    }
}

@Preview
@Composable
private fun BigButtonPreview(darkTheme: Boolean = false) {
    FoodieTheme {
        Column {
            BigButton(text = "Complete Order", isPrimaryButton = true) {}
            BigButton(text = "Complete Order", isPrimaryButton = false) {}
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


