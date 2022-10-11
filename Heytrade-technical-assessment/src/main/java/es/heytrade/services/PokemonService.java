package es.heytrade.services;

import java.util.List;
import java.util.Optional;

import es.heytrade.dtos.PokemonDTO;
import es.heytrade.entities.Type;


public interface PokemonService {

	/**
	 * Retrieve all Pokemon GET
	 * @return List of Pokemons
	 */
	public List<PokemonDTO> findAll();

	/**
	 * Retrive all favourite Pokemon GET
	 * @return List of Pokemons
	 */
	public List<PokemonDTO> findFavourites();

	/**
	 * Retrieve pokemon details
	 * @param idPokemon
	 * @return An optional Pokemon
	 */
	public Optional<PokemonDTO> getPokemon(Long idPokemon);

	/**
	 * Retrieve pokemons by partial name ignoring case
	 * @param name
	 * @return List of Pokemons
	 */
	public List<PokemonDTO> filterByName(String name);

	/**
	 * 
	 * @param type
	 * @return List of Pokemons
	 */
	public List<PokemonDTO> filterByTypes(Type type);

	/**
	 * Add/Remove Pokemon to/from favourites
	 * @return Boolean of success of the operation
	 */
	public Boolean switchFavouritePokemon(Long idPokemon);



}
