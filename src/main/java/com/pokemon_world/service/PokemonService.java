package com.pokemon_world.service;

import com.pokemon_world.config.client.PokeApiFeign;
import com.pokemon_world.config.client.responses.details.PokeDetailsResponse;
import com.pokemon_world.config.client.responses.list.PokeListResponse;
import com.pokemon_world.controller.dtos.ResponsePokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PokemonService {
    private final PokeApiFeign pokeApiFeign;

    public PokeListResponse listPokemons(int offset, int limit) {
        return pokeApiFeign.list(offset,limit);
    }

    public Optional<ResponsePokemon> getPokemonDetails(String idOrName) {
        PokeDetailsResponse pokemonDetails = pokeApiFeign.detail(idOrName);
        if (pokemonDetails == null) {
            return Optional.empty();
        }

        ResponsePokemon respPokemon = new ResponsePokemon();
        respPokemon.setName(pokemonDetails.name());
        respPokemon.setWeight(pokemonDetails.weight());
        respPokemon.setHeight(pokemonDetails.height());
        respPokemon.setBackDefaultSprite(pokemonDetails.sprites().back_default());
        respPokemon.setFrontDefaultSprite(pokemonDetails.sprites().front_default());

        return Optional.of(respPokemon);
    }
}

