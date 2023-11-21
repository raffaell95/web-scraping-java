package br.com.raffa.brasileiraoapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nomeEquipe;
	
	@NotBlank
	private String urlLogoEquipe;
}
