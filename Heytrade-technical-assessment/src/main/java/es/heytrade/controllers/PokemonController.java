package es.heytrade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.heytrade.dtos.PokemonDTO;
import es.heytrade.services.PokemonService;

@RestController
@RequestMapping("${api.name}${api.version}/")
public class PokemonController {

	@Autowired
	PokemonService pokemonService;


	@GetMapping("/all")
	public ResponseEntity<List<PokemonDTO>> getPokemons() {
		return ResponseEntity.ok(pokemonService.findAll());
	}



}