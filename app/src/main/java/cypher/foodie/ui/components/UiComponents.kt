package cypher.foodie.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography


@Composable
fun ElevatedCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
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
                .padding(all = MaterialTheme.spacing.large)
                .height(70.dp)
                .background(Color.Transparent),
            onClick = onClick,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp),
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


