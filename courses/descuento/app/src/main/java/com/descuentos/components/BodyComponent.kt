package com.descuentos.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun MainTextField(value : String , onValueChanget: (String) -> Unit, label: String){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanget ,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    )
}

@Composable
fun MainButton(text: String, color: Color = MaterialTheme.colorScheme.primary,
               onClik:()->Unit){
    OutlinedButton(onClick = onClik, colors = ButtonDefaults.outlinedButtonColors(
       contentColor = color,
        containerColor = Color.Transparent
    ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)) {
        Text(text = text)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Alert( title: String , message: String, confirmText: String,
           onConfirmClik:() -> Unit, onDismissCLick :() -> Unit
){

    AlertDialog(
        title = {
            Text(text = title)
        },
        text = {
            Text(text = message)
        },
        onDismissRequest = onDismissCLick,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmClik()
                }
            ) {
                Text(text = confirmText)
            }
        },

    )


}