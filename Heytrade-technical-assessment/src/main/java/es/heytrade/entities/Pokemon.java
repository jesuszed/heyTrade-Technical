package es.heytrade.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Pokemon implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPokemon;
	private String name;
	private Integer cp;
	private Integer hp;
	private Double minWeight;
	private Double maxWeight;
	private Double maxHeight;
	private Double minHeight;
	private Boolean favourite;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type")
	@JsonBackReference
	private List<Type> types;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pokemon")
	@JsonBackReference
	private List<Pokemon> evolutions;



}
