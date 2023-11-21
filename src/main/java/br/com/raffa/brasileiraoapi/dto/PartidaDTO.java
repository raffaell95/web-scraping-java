package br.com.raffa.brasileiraoapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nomeEquipeCasa;
	
	@NotBlank
	private String nomeEquipeVisitante;
	
	@NotBlank
	private String localPartida;
	
	@NotNull
	@ApiModelProperty(example = "dd/mm/yyyy hh:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
	private Date dataHoraPartida;
}
