package ua.oldev.fakeecommerceapp.core.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.oldev.fakeecommerceapp.core.presentation.theme.ComposeFakeEcommerceAppTheme

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    text: String,
    onRetry: (() -> Unit)? = null
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.padding(20.dp),
                imageVector = Icons.Default.Warning,
                tint = Color.Red,
                contentDescription = "Error description"
            )
            Text(text = text)
            if (onRetry != null) {
                ElevatedButton(
                    modifier = Modifier.padding(vertical = 20.dp),
                    onClick = onRetry
                ) {
                    Text(text = "Retry")
                }
            }
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
private fun ErrorScreenPreview() {
    ComposeFakeEcommerceAppTheme {
        ErrorScreen(
            text = "Failed to load data",
            onRetry = {}
        )
    }
}