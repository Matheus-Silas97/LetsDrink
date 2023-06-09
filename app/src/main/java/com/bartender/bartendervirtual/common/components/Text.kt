package com.bartender.bartendervirtual.common.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.bartender.bartendervirtual.common.theme.Typography

@Composable
fun TextTitle(text: String, modifier: Modifier = Modifier, textAlign: TextAlign? = null) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.titleLarge,
        color = Color.Black,
        fontWeight = FontWeight(700),
        textAlign = textAlign
    )
}

@Composable
fun TextSubTitle(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    textAlign: TextAlign? = null,
    maxLines: Int = 5
) {
    Text(
        text = text,
        modifier = modifier,
        color = textColor,
        style = Typography.titleMedium,
        fontWeight = FontWeight(600),
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun TextNormal(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    maxLines: Int = 15
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = Typography.bodyMedium,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun TextNormalSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    maxLines: Int = 15
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = Typography.labelMedium,
        textAlign = textAlign,
        maxLines = maxLines
    )
}