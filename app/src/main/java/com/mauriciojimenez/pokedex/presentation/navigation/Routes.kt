package com.mauriciojimenez.pokedex.presentation.navigation

sealed class Routes(val route: String) {
    object SplashScreen:Routes("splash_screen")
    object PokemonListScreen:Routes("list_screen")
    object PokemonSpeciesScreen : Routes("pokemon_species_screen")
}