package br.com.raffa.brasileiraoapi.service;

import java.util.List;

import br.com.raffa.brasileiraoapi.dto.PartidaGoogleDTO;
import br.com.raffa.brasileiraoapi.entity.Partida;
import br.com.raffa.brasileiraoapi.util.ScrapingUtil;
import br.com.raffa.brasileiraoapi.util.StatusPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrapingService {

	@Autowired
	private ScrapingUtil scrapingUtil;
	
	@Autowired
	private PartidaService partidaService;
	
	public void verificaPartidaPeriodo() {
		Integer quantidadePartida = partidaService.buscarQuantidadePartidasPeriodo();
		
		if (quantidadePartida > 0) {
			List<Partida> partidas = partidaService.listarPartidasPeriodo();
			
			partidas.forEach(partida -> {
				String urlPartida = scrapingUtil.montaUrlGoogle(
						partida.getEquipeCasa().getNomeEquipe(),
						partida.getEquipeVisitante().getNomeEquipe());

				PartidaGoogleDTO partidaGoogle = scrapingUtil.obtemInformacoesGoogle(urlPartida);

				if (partidaGoogle.getStatusPartida() != StatusPartida.PARTIDA_NAO_INICIADA) {
					partidaService.atualizaPartida(partida, partidaGoogle);
				}
			});
		}
	}
}
