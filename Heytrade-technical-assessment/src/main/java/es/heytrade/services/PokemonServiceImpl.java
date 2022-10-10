package es.heytrade.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.heytrade.dtos.PokemonDTO;
import es.heytrade.respositories.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	PokemonRepository pokemonRepository;


	ModelMapper mapper = new ModelMapper();

	@Override
	public List<PokemonDTO> findAll() {


		return pokemonRepository.findAll()
				.stream()
				.map(pokemon -> mapper.map(pokemon, PokemonDTO.class))
				.collect(Collectors.toList());



	}

}
