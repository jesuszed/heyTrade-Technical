package es.heytrade.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.heytrade.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	List<Pokemon> findByFavouriteTrue();

	List<Pokemon> findByNameContainingIgnoreCase(String name);

}
