package com.descuentos.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.unit.dp
import com.descuentos.components.Alert
import com.descuentos.components.MainButton
import com.descuentos.components.MainTextField
import com.descuentos.components.SpaceH
import com.descuentos.components.TwoCards
import com.descuentos.viewModels.CalcularViewModel1

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(viewModel1: CalcularViewModel1){
  Scaffold( topBar = {
       CenterAlignedTopAppBar(title = {
          Text(text = "Aplicacion con Descuentos", color = Color.White)
        }
        , colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.primary
        ))
     }
    ) {

      ContentHomeView(it, viewModel1)
  }
}


@Composable
fun ContentHomeView(paddingValues: PaddingValues , viewModel1: CalcularViewModel1){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
          //Text( text="Hola")
          //SpaceH()
          //Text( text= "Prueba")
        var precio by remember { mutableStateOf("") }
        var descuento by remember{ mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf(0.0) }
        var totalDescuento by remember { mutableStateOf(0.0) }
        var showAlert by remember { mutableStateOf(false) }

        TwoCards(title1 = "Total", number1 = totalDescuento,
                 title2 = "Descuento" , number2 = precioDescuento )

        MainTextField(value = precio, onValueChanget = { precio = it} , label = "Precio")
        SpaceH()
        MainTextField(value = descuento, onValueChanget ={descuento = it} , label = "Descuento" )
        SpaceH(10.dp)
        MainButton(text = "Generar Descuento"){
           val result = viewModel1.calcular(precio,descuento)
            showAlert = result.second.second;
            if ( !showAlert){
                precioDescuento = result.first
                totalDescuento = result.second.first
            }
        }
        SpaceH()
        MainButton(text = "Limpiar", color=Color.Red) {
            precio = ""
            descuento = ""
            precioDescuento = 0.0
            totalDescuento = 0.0
        }

        if( showAlert){
            Alert(title = "Alerta",
                message = "Escribe el precio y descuento" ,
                confirmText = "Aceptar",
                onConfirmClik = {
                    showAlert = false
                }) {}
        }
    }
}


