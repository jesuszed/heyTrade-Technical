package es.heytrade.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import es.heytrade.dtos.PokemonDTO;

@Service
public class PokemonServiceImpl implements PokemonService {

	HashSet<PokemonDTO> pokemonList = new HashSet<>();

	@Override
	public Set<PokemonDTO> findAll() {
		return pokemonList.isEmpty() ? null : pokemonList;
	}


}
