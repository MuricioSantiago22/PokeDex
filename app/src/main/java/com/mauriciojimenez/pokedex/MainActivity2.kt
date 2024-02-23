package com.mauriciojimenez.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.mauriciojimenez.pokedex.presentation.navigation.AppNavigation
import com.mauriciojimenez.pokedex.presentation.ui.theme.PokedexTheme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                MyActivityUi()
            }
        }
    }

    @Composable
    fun MyActivityUi() {
        AppNavigation()
    }
}