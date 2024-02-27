package com.mauriciojimenez.pokedex.presentation.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mauriciojimenez.pokedex.presentation.features.pokemonListView.PokemonListScreen
import com.mauriciojimenez.pokedex.presentation.features.pokemonSplashView.SplashScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route) {
        composable(route = Routes.SplashScreen.route) {
            SplashScreen(
                navController = navController
            )
        }

        composable(route= Routes.PokemonListScreen.route){
            PokemonListScreen(navController)

        }
    }

}

