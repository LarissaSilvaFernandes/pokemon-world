package com.pokemon_world.config.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.pokemon_world.config.client.responses.details.PokeDetailsResponse;
import com.pokemon_world.config.client.responses.list.PokeListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "default", url = "${spring.cloud.openfeign.client.config.poke-api.url}")
public interface PokeApiFeign {
    @GetMapping("/pokemon")
    PokeListResponse list(@RequestParam int offset, @RequestParam int limit);

    @GetMapping("/pokemon/{idOrName}")
    PokeDetailsResponse detail(@PathVariable String idOrName);

    @GetMapping("/pokemon-species/{id}")
    JsonNode species(@PathVariable int id);

    @GetMapping("/evolution-chain/{id}")
    JsonNode evolutionChain(@PathVariable int id);
}

