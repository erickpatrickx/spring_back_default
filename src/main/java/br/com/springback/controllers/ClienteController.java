package br.com.springback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springback.dto.ClienteDTO;
import br.com.springback.exception.BadRequestException;
import br.com.springback.service.ClienteService;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

	
	private final ClienteService clienteService;

    @Autowired
	public ClienteController(ClienteService usuarioService) {
	        this.clienteService = usuarioService;
	 }
	
	
	

	@PostMapping("/save")
	public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO dto) {
		 if (dto.getId() != null) {
	            throw new BadRequestException("Id existente para Cliente");
	      }
		 ClienteDTO result = clienteService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
}
