package es.heytrade.dtos;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import es.heytrade.entities.Type;
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
	private Integer cp;
	private Integer hp;
	private Double minWeight;
	private Double maxWeight;
	private Double maxHeight;
	private Double minHeight;
	private Boolean favourite;
	private List<Type> types;
	private List<PokemonDTOSimple> evolutions;

}
