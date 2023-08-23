package com.elena_balakhnina.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.elena_balakhnina.compose.theme.ExampleComposeTheme

@Preview
@Composable
fun OptionGroup(
    @PreviewParameter(provider = OptionPreviewParameterProvider::class)
    options: List<String>,
    selectedOption: Int = -1,
    validOption: Int = -1,
    onOptionSelected: (Int) -> Unit = {}
) {
    ExampleComposeTheme {
        LazyColumn {
            itemsIndexed(options) { index, item ->
                OptionItem(
                    isSelected = index == selectedOption,
                    text = item,
                    onClick = {
                        if (selectedOption != index) {
                            onOptionSelected(index)
                        }
                    },
                    showStatus = selectedOption == index,
                    isValid = index == validOption
                )
            }
        }
    }
}

internal class OptionPreviewParameterProvider : PreviewParameterProvider<List<String>> {
    override val values: Sequence<List<String>>
        get() = sequenceOf(listOf("option A", "option B", "option C"))
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun OptionItem(
    isSelected: Boolean,
    isValid: Boolean,
    showStatus: Boolean,
    text: String,
    onClick: () -> Unit
) {
    val bkgColor = if(showStatus) {
        if(isValid) {
            MaterialTheme.colors.primary
        } else {
            MaterialTheme.colors.error
        }
    } else {
        MaterialTheme.colors.primaryVariant
    }

    Surface(
        color = bkgColor,
        modifier = Modifier.padding(4.dp),
        onClick = onClick,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RadioButton(
                selected = isSelected,
                onClick = onClick,
            )
            Text(text = text)
        }
    }


}