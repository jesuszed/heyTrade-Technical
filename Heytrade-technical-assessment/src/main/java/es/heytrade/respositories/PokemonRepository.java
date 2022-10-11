package es.heytrade.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.heytrade.entities.Pokemon;
import es.heytrade.entities.Type;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	List<Pokemon> findByFavouriteTrue();

	List<Pokemon> findByNameContainingIgnoreCase(String name);

	List<Pokemon> findByTypes(Type type);
}
