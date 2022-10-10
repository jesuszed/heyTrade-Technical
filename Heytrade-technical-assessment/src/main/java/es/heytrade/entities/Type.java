package es.heytrade.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import es.heytrade.dtos.TypeDTO;
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
@Table(name = "type")
public class Type {

	@Autowired
	ModelMapper modelMapper;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idType")
	private Long idType;

	@Column(name = "name", length = 100)
	private String name;

	private TypeDTO toDTO(Type type) {
		return modelMapper.map(type, TypeDTO.class);
	}
}
