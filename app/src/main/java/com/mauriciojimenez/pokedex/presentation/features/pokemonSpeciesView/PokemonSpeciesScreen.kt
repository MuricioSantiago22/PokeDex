package com.mauriciojimenez.pokedex.presentation.features.pokemonSpeciesView

import android.app.StatusBarManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonSpeciesScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text( "Specie")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White
                )
            )
        }
    ) {padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ){
            Text("Name:", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.ExtraBold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Happiness:", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.ExtraBold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Capture Rate:", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.ExtraBold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Egg Groups:", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.ExtraBold)
            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp)
                .background(Color.Red, shape = RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                Text(text = "Evolutionary Line", color = Color.White)
            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp)
                .background(Color.Red, shape = RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(Color.Transparent)){
                Text(text = "Skills", color = Color.White)
            }




        }
        


    }
}