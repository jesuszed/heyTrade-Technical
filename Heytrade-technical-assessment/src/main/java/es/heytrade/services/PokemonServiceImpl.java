package es.heytrade.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.heytrade.config.exceptions.EntityNotFoundException;
import es.heytrade.dtos.PokemonDTO;
import es.heytrade.entities.Pokemon;
import es.heytrade.entities.Type;
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

	@Override
	public List<PokemonDTO> findFavourites() {

		return pokemonRepository.findByFavouriteTrue()
				.stream()
				.map(pokemon -> mapper.map(pokemon, PokemonDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<PokemonDTO> getPokemon(Long idPokemon) {

		Optional<Pokemon> optPokemon = pokemonRepository.findById(idPokemon);
		Optional<PokemonDTO> optPokemonDto = optPokemon.isPresent()
				? Optional.of(mapper.map(optPokemon.get(), PokemonDTO.class))
				: Optional.empty();

		return Optional.ofNullable(optPokemonDto)
				.orElseThrow(() -> new EntityNotFoundException(Pokemon.class, "identificador " + idPokemon));
	}

	@Override
	public List<PokemonDTO> filterByName(String name) {

		return pokemonRepository.findByNameContainingIgnoreCase(name)
				.stream()
				.map(pokemon -> mapper.map(pokemon, PokemonDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<PokemonDTO> filterByTypes(Type type) {

		return pokemonRepository.findByTypes(type)
				.stream()
				.map(pokemon -> mapper.map(pokemon, PokemonDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PokemonDTO setFavouriteTrue() {
		return null;
	}

	@Override
	public PokemonDTO setFavouriteFalse() {
		return null;
	}



}
