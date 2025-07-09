package cypher.foodie.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import cypher.foodie.R

data class Spacing(
    val default: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 12.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 24.dp,
    val xxLarge: Dp = 32.dp
)


val textFamily = FontFamily(
    Font(R.font.sf_pro_regular, FontWeight.Normal),
    Font(R.font.sf_pro_medium, FontWeight.Medium),
    Font(R.font.sf_pro_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_bold, FontWeight.Bold),
)


data class TextTypography(
    val textBold: TextStyle = TextStyle(
        fontFamily = textFamily,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Bold
    ),
    val textSemiBold: TextStyle = TextStyle(
        fontFamily = textFamily,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.SemiBold
    ),
    val textRegular: TextStyle = TextStyle(
        fontFamily = textFamily,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Normal
    )
)

val roundedFamily = FontFamily(
    Font(R.font.sf_pro_rounded_bold, FontWeight.Bold),
    Font(R.font.sf_pro_rounded_heavy, FontWeight.ExtraBold),
    Font(R.font.sf_pro_rounded_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_rounded_regular, FontWeight.Normal)
)

data class RoundedTypography(
    val roundedHeavy: TextStyle = TextStyle(
        fontFamily = roundedFamily,
        fontSize = 65.sp,
        lineHeight = 65.sp,
        letterSpacing = (-0.03).em, fontWeight = FontWeight.ExtraBold
    ),
    val roundedBold: TextStyle = TextStyle(
        fontFamily = roundedFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        letterSpacing = 0.sp
    ),
    val roundedRegular: TextStyle = TextStyle(
        fontFamily = roundedFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    val roundedSemiBold: TextStyle = TextStyle(
        fontFamily = roundedFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
)

val LocalSpacing = compositionLocalOf { Spacing() }
val LocalRoundedTypography = compositionLocalOf { RoundedTypography() }
val LocalTextTypography = compositionLocalOf { TextTypography() }

val MaterialTheme.spacing: Spacing
    @Composable @ReadOnlyComposable get() = LocalSpacing.current

val MaterialTheme.roundedTypography: RoundedTypography
    @Composable @ReadOnlyComposable get() = LocalRoundedTypography.current

val MaterialTheme.textTypography: TextTypography
    @Composable @ReadOnlyComposable get() = LocalTextTypography.current
