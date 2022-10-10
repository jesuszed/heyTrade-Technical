package es.heytrade.services;

import java.util.List;

import es.heytrade.dtos.PokemonDTO;


public interface PokemonService {

	//Retrieve all Pokemon GET
	public List<PokemonDTO> findAll();



}
