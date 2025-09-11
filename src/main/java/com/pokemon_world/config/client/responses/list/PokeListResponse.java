package com.pokemon_world.config.client.responses.list;

import java.util.List;

public record PokeListResponse(int count, List<PokeListItem> results) {
}
