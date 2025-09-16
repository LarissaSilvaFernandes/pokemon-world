# 🌍 Pokemon World API
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](LICENSE)





## API construída em **Java 24 + Spring Boot 3.5.5** que consome dados da [PokeAPI](https://pokeapi.co/).
O projeto expõe endpoints REST para listar e detalhar pokémons, com suporte a paginação (`offset`, `limit`).

## 🛠️ Stack utilizada

- **Java 24**
- **Spring Boot 3.5.5**
- **Spring Cloud OpenFeign** → integração declarativa com a PokeAPI
- **Spring Validation** → validação de parâmetros
- **Lombok** → reduzir boilerplate



**Exemplo de resposta listar pokémons** ⚡ Endpoints:
```GET http://localhost:6060/api/v1/pokemon/list?offset=0&limit=4```
```json
{
  "count": 1302,
  "results": [
    {
      "name": "bulbasaur",
      "url": "https://pokeapi.co/api/v2/pokemon/1/"
    },
    {
      "name": "ivysaur",
      "url": "https://pokeapi.co/api/v2/pokemon/2/"
    },
    {
      "name": "venusaur",
      "url": "https://pokeapi.co/api/v2/pokemon/3/"
    },
    {
      "name": "charmander",
      "url": "https://pokeapi.co/api/v2/pokemon/4/"
    }
  ]
}
```

**Exemplo de resposta detalhar pokémons** ⚡ Endpoints:
```GET http://localhost:6060/api/v1/pokemon/details/charmander```

``` json
{
"name": "charmander",
"frontDefaultSprite": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
"backDefaultSprite": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/4.png",
"height": 6,
"weight": 85
}
```


A aplicação sobe na porta:
👉 http://localhost:6060