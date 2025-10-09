package com.pokemon_world.controller;


import com.pokemon_world.config.client.responses.list.PokeListResponse;
import com.pokemon_world.controller.dtos.ResponsePokemon;
import com.pokemon_world.service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pokemon")
@RequiredArgsConstructor
@Tag(name = "Pokémon API", description = "API para consulta de Pokémon")
public class PokemonController {


    private final PokemonService pokemonService;

    @Operation(summary = "Lista os Pokémons de forma paginada", description = "Retorna uma lista de 20 Pokémons por página.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping("/list")
    public ResponseEntity<PokeListResponse> listPokemonPokeApi(
            @Parameter(description = "Deslocamento da página (offset)", example = "0") @RequestParam(defaultValue = "0") int offset,
            @Parameter(description = "Limite de itens por página", example = "20") @RequestParam(defaultValue = "20") int limit) {
        return ResponseEntity.ok(pokemonService.listPokemons(offset, limit));
    }

    @Operation(summary = "Busca os detalhes de um Pokémon específico", description = "Retorna os detalhes de um Pokémon pelo seu nome ou ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pokémon encontrado com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponsePokemon.class)) }),
            @ApiResponse(responseCode = "404", description = "Pokémon não encontrado", content = @Content)
    })
    @GetMapping("/details/{idOrName}")
    public ResponseEntity<ResponsePokemon> getPokemonDetails(@Parameter(description = "Nome ou ID do Pokémon a ser buscado", example = "pikachu") @PathVariable String idOrName) {
        Optional<ResponsePokemon> result = pokemonService.getPokemonDetails(idOrName);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
