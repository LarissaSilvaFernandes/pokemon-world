package com.pokemon_world.controller;


import com.pokemon_world.config.client.responses.list.PokeListResponse;
import com.pokemon_world.controller.dtos.ResponsePokemon;
import com.pokemon_world.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pokemon")
@RequiredArgsConstructor
public class PokemonController {


    private final PokemonService pokemonService;

    @GetMapping("/list")
    public ResponseEntity<PokeListResponse> listPokemonPokeApi(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "20") int limit) {
        return ResponseEntity.ok(pokemonService.listPokemons(offset, limit));
    }

    @GetMapping("/details/{idOrName}")
    public ResponseEntity<ResponsePokemon> getPokemonDetails(@PathVariable String idOrName) {
        Optional<ResponsePokemon> result = pokemonService.getPokemonDetails(idOrName);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
