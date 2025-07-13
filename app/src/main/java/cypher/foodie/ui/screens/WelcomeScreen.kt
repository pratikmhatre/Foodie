package cypher.foodie.ui.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cypher.foodie.R
import cypher.foodie.ui.components.BigButton
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing


@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, onGetStartedClicked: () -> Unit) {
    FoodieTheme {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.TopStart
        ) {
            Column(Modifier.padding(MaterialTheme.spacing.xxLarge)) {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.inverseOnSurface, shape = CircleShape)
                        .size(75.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_chef_big),
                        contentDescription = "",
                        modifier = Modifier.padding(MaterialTheme.spacing.medium)
                    )
                }
                Spacer(Modifier.height(MaterialTheme.spacing.extraLarge))
                Text(
                    text = "Food for\nEveryone",
                    style = MaterialTheme.roundedTypography.roundedHeavy,
                    color = MaterialTheme.colorScheme.inverseOnSurface
                )
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 190.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_toyface_first), contentDescription = "", Modifier
                        .align(
                            Alignment.CenterStart
                        )
                        .scale(1.5f)
                )
                Image(
                    painter = painterResource(R.drawable.img_toyface_second), contentDescription = "", Modifier
                        .align(
                            Alignment.BottomEnd
                        )
                        .scale(1.5f)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0x00FA4A0C),
                                Color(0xB3FA4A0C),
                                Color(0xCCFA4A0C),
                                Color(0xE6FA4A0C),
                                Color(0xFFFA4A0C),
                                MaterialTheme.colorScheme.primary
                            )
                        )
                    )
                    .align(Alignment.BottomCenter)
            )

            BigButton(
                text = R.string.get_started,
                isPrimaryButton = false,
                modifier = Modifier.align(Alignment.BottomCenter), onClick = onGetStartedClicked
            )
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(onGetStartedClicked = {})
}