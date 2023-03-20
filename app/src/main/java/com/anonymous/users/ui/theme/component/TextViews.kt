package com.anonymous.users.ui.theme.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Title(text: String, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.primary
    )
}

@Composable
fun CaptionTitle(text: String, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.secondary
    )
}

@Composable
fun MobileNumber(text: String, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.primary
    )
}

@Composable
fun StickersName(name: String, modifier: Modifier) {
    Text(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp),
        text = name,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.secondary
    )
}

@Composable
fun TextImage(name: String) {
    Text(
        textAlign = TextAlign.Justify,
        text = name,
        style = MaterialTheme.typography.subtitle2,
        color = MaterialTheme.colors.secondary,
    )
}

@Composable
fun SelectedStickersName(name: String, modifier: Modifier) {
    Text(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.onSecondary,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp),
        text = name,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.onPrimary
    )
}

@Composable
fun Address(text: String, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.primary
    )
}

@Composable
fun Name(text: String, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.h5,
        color = MaterialTheme.colors.primary
    )
}
