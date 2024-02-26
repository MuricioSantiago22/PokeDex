package com.mauriciojimenez.pokedex.presentation.features.pokemonListView

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mauriciojimenez.pokedex.ui.theme.PokedexTheme


/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(navController: NavController){
    val viewModel: PokemonListViewModel = hiltViewModel()
    val nameList = viewModel.pokemonNameList.observeAsState(initial = emptyList())

    PokedexTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Pokemon")
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color.DarkGray,
                        titleContentColor = Color.White,
                    )
                )
            },
        ) { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding)
            ) {
                items(pokemonNameList.value) { pokemonData ->
                    PokemonListCell(pokemon = pokemonData, navController = navController)
                }
            }
        }
    }
}*/