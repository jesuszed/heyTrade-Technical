package es.heytrade.services;

import java.util.Set;

import es.heytrade.dtos.PokemonDTO;


public interface PokemonService {

	//Retrieve all Pokemon GET
	public Set<PokemonDTO> findAll();



}
