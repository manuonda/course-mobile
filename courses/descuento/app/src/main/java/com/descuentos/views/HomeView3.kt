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
import com.descuentos.viewModels.CalcularViewModel2
import com.descuentos.viewModels.CalcularViewModel3

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView3(viewModel1: CalcularViewModel3){
    Scaffold( topBar = {
        CenterAlignedTopAppBar(title = {
            Text(text = "Aplicacion con Descuentos", color = Color.White)
        }
            , colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ))
    }
    ) {

        ContentHomeView3(it, viewModel1)
    }
}


@Composable
fun ContentHomeView3(paddingValues: PaddingValues , viewModel: CalcularViewModel3){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = viewModel.state

        TwoCards(title1 = "Total",
            number1 = state.totalDescuento,
            title2 = "Descuento" ,
            number2 = state.precioDescuento )

        MainTextField(value = state.precio,
            onValueChanget = { viewModel.onValue(it,"precio")} ,
            label = "Precio")
        SpaceH()
        MainTextField(value = state.descuento,
            onValueChanget ={viewModel.onValue(it,"descuento")} ,
            label = "Descuento" )
        SpaceH(10.dp)
        MainButton(text = "Generar Descuento"){
            viewModel.calcular()
        }
        SpaceH()
        MainButton(text = "Limpiar", color=Color.Red) {
             viewModel.limpiar()
        }

        if( state.showAlert){
            Alert(title = "Alerta",
                message = "Escribe el precio y descuento" ,
                confirmText = "Aceptar",
                onConfirmClik = { viewModel.cancelAlert() }) {}
        }
    }
}


