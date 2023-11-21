package br.com.raffa.brasileiraoapi.dto;

import br.com.raffa.brasileiraoapi.entity.Equipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipeResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Equipe> equipes;

	public void setEquipes(List<Equipe> all) {
	}
}
