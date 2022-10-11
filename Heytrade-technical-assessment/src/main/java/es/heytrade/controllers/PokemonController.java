package es.heytrade.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.heytrade.dtos.PokemonDTO;
import es.heytrade.entities.Type;
import es.heytrade.services.PokemonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "${api.name}${api.version}/", produces = MediaType.APPLICATION_JSON_VALUE)
public class PokemonController {

	@Autowired
	PokemonService pokemonService;

	@ApiOperation(value = "Get all Pokemons")
	@GetMapping("/pokemons")
	public ResponseEntity<List<PokemonDTO>> getPokemons() {
		return ResponseEntity.ok(pokemonService.findAll());
	}


	@ApiOperation(value = "Get all favourites Pokemons")
	@GetMapping("/pokemons/favourites")
	public ResponseEntity<List<PokemonDTO>> getFavourites() {
		return ResponseEntity.ok(pokemonService.findFavourites());
	}


	@ApiOperation(value = "Get Pokemon details")
	@GetMapping("/pokemons/{id}")
	public ResponseEntity<PokemonDTO> getPokemon(@ApiParam(
			name = "idPokemon",
			type = "long",
			example = "1",
			value = "Pokemon's identification",
			required = true) @PathVariable("id") Long idPokemon) {
		Optional<PokemonDTO> optPokemon = pokemonService.getPokemon(idPokemon);
		return ResponseEntity.of(optPokemon);
	}


	@ApiOperation(value = "Search for Pokemon by text.")
	@GetMapping("/pokemons/filter/{name}")
	public ResponseEntity<List<PokemonDTO>> getPokemon(@ApiParam(
			name = "name",
			type = "String",
			example = "Char",
			value = "Pokemon's partial name ignoring case",
			required = true) @PathVariable("name") String name) {
		return ResponseEntity.ok(pokemonService.filterByName(name));
	}

	@ApiOperation(value = "Search for Pokemon by text.")
	@GetMapping("/pokemons/filter/type/{type}")
	public ResponseEntity<List<PokemonDTO>> getPokemon(@ApiParam(
			name = "type",
			type = "Type",
			example = "1",
			value = "Pokemon's type",
			required = false) @PathVariable(name = "type", required = false) Type type) {
		return ResponseEntity.ok(pokemonService.filterByTypes(type));
	}



}
