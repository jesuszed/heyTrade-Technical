package es.heytrade.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class TypeDTO {
	private Long idType;
	@NotNull
	@Max(value = 100, message = "Size name excedeed")
	private Long name;

}
