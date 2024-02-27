package com.example.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacion.components.ActionButton
import com.example.navegacion.components.MainButton
import com.example.navegacion.components.Space
import com.example.navegacion.components.TitleBar
import com.example.navegacion.components.TitleView


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController){
   Scaffold(
       topBar = {
           CenterAlignedTopAppBar(
               title = { TitleBar(name = "Home View ")},
               colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                  containerColor = Color.Red
              )
           )
       },
       floatingActionButton = { ActionButton() }

   ) {
       ContentHomeView(navController)
   }
}


@Composable
fun ContentHomeView(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      TitleView(name = "Home")
        Space()
        MainButton(name = "Detail View" , backColor = Color.Red, color = Color.White ) {
            println("Soy button main button")
            navController.navigate("Detail")
        }
    } 
}