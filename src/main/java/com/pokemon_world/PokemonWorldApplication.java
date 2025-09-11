package com.pokemon_world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PokemonWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonWorldApplication.class, args);
    }

}
