package com.pokemon_world.controller.dtos;

import lombok.Data;

@Data
public class ResponsePokemon {
    private String name;
    private String frontDefaultSprite;
    private String backDefaultSprite;
    private int height;
    private int weight;
}



