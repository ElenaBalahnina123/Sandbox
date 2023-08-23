package com.elena_balakhnina.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elena_balakhnina.compose.theme.ExampleComposeTheme

@Preview
@Composable
private fun ToolbarPreview() {
    ExampleComposeTheme {
        Toolbar(
            title = "Toolbar title",
            startIcon = {
                Icon(
                    contentDescription = "back",
                    imageVector = Icons.Default.ArrowBack
                )
            },
            endIcon = {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null
                )
            }
        )
    }
}

@Composable
fun Toolbar(
    title: String,
    startIcon: (@Composable ()->Unit)? = null,
    endIcon: (@Composable ()->Unit)? = null,
) {
    TopAppBar {
        CompositionLocalProvider(
            LocalContentAlpha provides 1f,
        ) {
            Spacer(modifier = Modifier.padding(start = 16.dp))
            if(startIcon != null) {
                startIcon()
                Spacer(modifier = Modifier.padding(start = 16.dp))
            }
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if(endIcon != null) {
                endIcon()
                Spacer(modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}