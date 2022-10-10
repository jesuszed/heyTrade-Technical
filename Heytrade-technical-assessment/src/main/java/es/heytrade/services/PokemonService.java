package es.heytrade.services;

import java.util.List;
import java.util.Optional;

import es.heytrade.dtos.PokemonDTO;


public interface PokemonService {

	//Retrieve all Pokemon GET
	public List<PokemonDTO> findAll();

	//Retrive all favourite Pokemon GET
	public List<PokemonDTO> findFavourites();

	//Retrieve pokemon details
	public Optional<PokemonDTO> getPokemon(Long idPokemon);

	public List<PokemonDTO> filterByName(String name);


}
