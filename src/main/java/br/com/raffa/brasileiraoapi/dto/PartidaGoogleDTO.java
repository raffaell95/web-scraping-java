package br.com.raffa.brasileiraoapi.dto;

import br.com.phc.brasileiraoapi.util.StatusPartida;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PartidaGoogleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private StatusPartida statusPartida;
	private String tempoPartida;
	
	private String nomeEquipeCasa;
	private String urlLogoEquipeCasa;
	private Integer placarEquipeCasa;
	private String golsEquipeCasa;
	private Integer placarEstendidoEquipeCasa;
	
	private String nomeEquipeVisitante;
	private String urlLogoEquipeVisitante;
	private Integer placarEquipeVisitante;
	private String golsEquipeVisitante;
	private Integer placarEstendidoEquipeVisitante;
	
}
