package es.heytrade.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.heytrade.entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
