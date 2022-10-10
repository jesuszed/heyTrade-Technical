package es.heytrade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import es.heytrade.dtos.PokemonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Autowired
	ModelMapper modelMapper;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPokemon")
	private Long idPokemon;

	@Column(name = "name", length = 100)
	private String name;

	private PokemonDTO toDTO(Pokemon pokemon) {
		return modelMapper.map(pokemon, PokemonDTO.class);
	}

}
