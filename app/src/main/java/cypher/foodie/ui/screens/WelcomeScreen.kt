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
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.roundedTypography
import cypher.foodie.ui.theme.spacing


@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    FoodieTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.TopStart
        ) {
            Column(Modifier.padding(MaterialTheme.spacing.xxLarge)) {
                Box(modifier = Modifier.background(Color.White, shape = CircleShape)) {
                    Image(
                        painter = painterResource(R.drawable.img_chef_small),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(
                                MaterialTheme.spacing.large
                            )
                    )
                }
                Spacer(Modifier.height(MaterialTheme.spacing.extraLarge))
                Text(
                    text = "Food for\nEveryone",
                    style = MaterialTheme.roundedTypography.roundedHeavy,
                    color = Color.White
                )
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 180.dp)
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
                            Alignment.CenterEnd
                        )
                        .scale(1.5f)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(brush = Brush.verticalGradient(
                        colors = listOf(Color(0x0dFA4A0C), Color(0x3dFA4A0C), MaterialTheme.colorScheme.primary)
                    ))
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}