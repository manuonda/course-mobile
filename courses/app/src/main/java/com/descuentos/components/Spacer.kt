package com.descuentos.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun SpaceH(size: Dp = 10.dp){
    Spacer(modifier = Modifier.height(size))

}

@Composable
fun SpaceW(size: Dp = 10.dp){
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun MainTextField(value : String , onValueChanget: (String) -> Unit, label: String){
    OutlinedTextField(
         value = value,
         onValueChange = onValueChanget ,
         label = { Text(text = label) },
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
         modifier = Modifier.fillMaxWidth()
             .padding(horizontal = 30.dp)
     )
}