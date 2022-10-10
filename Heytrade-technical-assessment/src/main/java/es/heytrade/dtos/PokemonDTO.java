package es.heytrade.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {
	private Long idPokemon;
	@NotNull
	@Max(value = 100, message = "Size name excedeed")
	private String name;

}
