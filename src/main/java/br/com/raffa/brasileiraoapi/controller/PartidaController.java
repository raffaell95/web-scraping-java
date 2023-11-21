package br.com.raffa.brasileiraoapi.controller;

import br.com.raffa.brasileiraoapi.dto.PartidaDTO;
import br.com.raffa.brasileiraoapi.dto.PartidaResponseDTO;
import br.com.raffa.brasileiraoapi.entity.Partida;
import br.com.raffa.brasileiraoapi.execption.StandardError;
import br.com.raffa.brasileiraoapi.service.PartidaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Api("API de partidas")
@RestController
@RequestMapping("/api/v1/partidas")
public class PartidaController {

	@Autowired
	private PartidaService partidaService;
	
	@ApiOperation(value = "Buscar partida por id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Partida.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class)
	})
	@GetMapping("/{id}")
	public ResponseEntity<Partida> buscarPartidaPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(partidaService.buscarPartidaPorId(id));
	}
	
	@ApiOperation(value = "Listar partidas")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = PartidaResponseDTO.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class)
	})
	@GetMapping
	public ResponseEntity<PartidaResponseDTO> listarPartidas() {
		return ResponseEntity.ok().body(partidaService.listarPartidas());
	}
	
	@ApiOperation(value = "Inserir partida")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created", response = Partida.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class)
	})
	@PostMapping
	public ResponseEntity<Partida> inserirPartida(@Valid @RequestBody PartidaDTO dto) {
		Partida partida = partidaService.inserirPartida(dto);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(partida.getId()).toUri();
		
		return ResponseEntity.created(location).body(partida);
	}
	
	@ApiOperation(value = "Alterar partida")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "No content", response = Void.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class)
	})
	@PutMapping("/{id}")
	public ResponseEntity<Void> alterarPartida(@PathVariable("id") Long id,
			@Valid @RequestBody PartidaDTO dto) {
		partidaService.alterarPartida(id, dto);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
}
