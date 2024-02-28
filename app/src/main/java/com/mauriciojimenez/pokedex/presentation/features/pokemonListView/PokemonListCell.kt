package com.mauriciojimenez.pokedex.presentation.features.pokemonListView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mauriciojimenez.pokedex.domain.entities.data.PokemonData
import com.mauriciojimenez.pokedex.presentation.navigation.Routes
@Composable
fun PokemonListCell(pokemon: PokemonData, navController: NavController){
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(
                    route = Routes.PokemonSpeciesScreen.route
                )
            }
    ){
        AsyncImage(
            model = pokemon.url,
            contentDescription = "",
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(4.dp)
        )
        Spacer(
            modifier = Modifier
                .padding(4.dp)
        )
        Column {
            pokemon.name.let {
                Text(
                    it,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold

                )
            }
        }
    }
}