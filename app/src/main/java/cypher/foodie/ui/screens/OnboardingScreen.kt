package cypher.foodie.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cypher.foodie.R
import cypher.foodie.ui.components.BigButton
import cypher.foodie.ui.theme.FoodieTheme
import cypher.foodie.ui.theme.spacing
import cypher.foodie.ui.theme.textTypography

data class TabItem(val title: String, val isSelected: Boolean)

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    val tabs = listOf(
        TabItem(title = stringResource(R.string.login), isSelected = true),
        TabItem(title = stringResource(R.string.signup), isSelected = false)
    )
    var selectedTab by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { tabs.size })

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (pagerState.isScrollInProgress.not()) selectedTab = pagerState.currentPage
    }

    LaunchedEffect(selectedTab) {
        pagerState.animateScrollToPage(selectedTab)
    }

    Box(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalPager(modifier = Modifier.fillMaxSize(), state = pagerState) {
            when (it) {
                0 -> LoginFrame()
                1 -> SignupFrame()
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(
                bottomEnd = MaterialTheme.spacing.xxLarge, bottomStart = MaterialTheme.spacing.xxLarge
            )
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.size(110.dp),
                    painter = painterResource(R.drawable.img_chef_big),
                    contentDescription = "Chef logo"
                )
                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = Color.Transparent,
                    modifier = Modifier.align(Alignment.BottomCenter), divider = {},
                ) {
                    tabs.forEachIndexed { index, tab ->
                        Tab(selected = tab.isSelected, text = { Text(tab.title, style = MaterialTheme.textTypography.textSemiBold, fontSize = 18.sp, color = Color.Black) }, onClick = {
                            selectedTab = index
                        })
                    }
                }
            }
        }

    }
}

@Composable
fun LoginFrame(modifier: Modifier = Modifier) {
    var emailAddress by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center
    ) {
        Column(Modifier.padding(MaterialTheme.spacing.extraLarge)) {
            FormInput(
                modifier = Modifier,
                label = R.string.email_address,
                placeHolder = R.string.enter_email_address,
                text = emailAddress,
                onTextChanged = { emailAddress = it })
            Spacer(Modifier.height(MaterialTheme.spacing.extraLarge))
            FormInput(
                modifier = Modifier,
                label = R.string.password,
                placeHolder = R.string.enter_password,
                text = password,
                isPassword = true,
                onTextChanged = { password = it })
            Spacer(Modifier.height(MaterialTheme.spacing.xxLarge))
            Text(
                text = stringResource(R.string.forgot_passcode),
                style = MaterialTheme.textTypography.textSemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
        BigButton(modifier = Modifier.align(Alignment.BottomCenter), isPrimaryButton = true, text = R.string.login) { }
    }
}

@Composable
fun SignupFrame(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var emailAddress by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center
    ) {
        Column(Modifier.padding(MaterialTheme.spacing.extraLarge), verticalArrangement = Arrangement.Center ) {
            FormInput(
                modifier = Modifier,
                label = R.string.name,
                placeHolder = R.string.enter_full_name,
                text = name,
                onTextChanged = { name = it })
            Spacer(Modifier.height(MaterialTheme.spacing.large))
            FormInput(
                modifier = Modifier,
                label = R.string.email_address,
                placeHolder = R.string.enter_email_address,
                text = emailAddress,
                onTextChanged = { emailAddress = it })
            Spacer(Modifier.height(MaterialTheme.spacing.large))
            FormInput(
                modifier = Modifier,
                label = R.string.password,
                placeHolder = R.string.enter_password,
                text = password,
                isPassword = true,
                onTextChanged = { password = it })
        }
        BigButton(isPrimaryButton = true, text = R.string.signup, modifier = Modifier.align(Alignment.BottomCenter)) { }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    @StringRes placeHolder: Int,
    text: String,
    isPassword: Boolean = false,
    onTextChanged: (String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val colors = TextFieldDefaults.colors(
        unfocusedContainerColor = Color.Transparent,
        focusedContainerColor = Color.Transparent,
    )
    BasicTextField(
        value = text,
        onValueChange = onTextChanged,
        modifier = modifier.fillMaxWidth(),
        textStyle = MaterialTheme.textTypography.textSemiBold.copy(
            fontSize = 17.sp, color = MaterialTheme.colorScheme.onSurface // Ensure text color is set
        ),
        interactionSource = interactionSource,
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = text,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(0.dp),
                label = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(label),
                        style = MaterialTheme.textTypography.textRegular,
                        fontSize = 15.sp,
                        color = Color.Black.copy(alpha = 0.4f)
                    )
                },
                placeholder = {
                    if (text.isEmpty()) { // Only show placeholder if text is empty
                        Text(
                            text = stringResource(placeHolder),
                            style = MaterialTheme.textTypography.textRegular,
                            fontSize = 17.sp
                        )
                    }
                },
                colors = colors,
            )
        })
}

@Preview
@Composable
private fun FormInputPreview() {
    FoodieTheme {
        Box(Modifier.background(Color.White)) {
            FormInput(
                modifier = Modifier.padding(16.dp),
                label = R.string.email_address,
                placeHolder = R.string.enter_email_address,
                text = "pnmhatre@gmail.com",
                onTextChanged = {})

        }
    }
}

@Preview
@Composable
private fun LoginFramePreview() {
    FoodieTheme {
        LoginFrame()
    }
}

@Preview
@Composable
private fun SignupFramePreview() {
    FoodieTheme {
        SignupFrame()
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    FoodieTheme {
        OnboardingScreen()
    }
}