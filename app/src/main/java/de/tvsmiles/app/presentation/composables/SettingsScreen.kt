package de.tvsmiles.app.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.tvsmiles.app.R

@Composable
fun SettingsScreen(
    onShowSettings: () -> Unit,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.white))
    ) {

        Column {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp, top = 20.dp, end = 10.dp, bottom = 0.dp
                ), onClick = {
                onShowSettings.invoke()
            }) {
                Text(
                    "show Debugger Screen",
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp, 5.dp, 5.dp, 5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(onShowSettings = {

    })
}