package br.com.springback.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springback.dto.ClienteDTO;
import br.com.springback.exception.BadRequestException;
import br.com.springback.service.ClienteService;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

	
	private final ClienteService clienteService;

    @Autowired
	public ClienteController(ClienteService usuarioService) {
	        this.clienteService = usuarioService;
	 }
	
    
    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return ResponseEntity.ok().body(clienteService.findAll());
    }
	@PostMapping("/save")
	public ResponseEntity<ClienteDTO> salvar(@Validated @RequestBody ClienteDTO dto) {
		 if (dto.getId() != null) {
	            throw new BadRequestException("Id existente para Cliente");
	      }
		 ClienteDTO result = clienteService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	
    @PutMapping("/update")
    public ResponseEntity<ClienteDTO> updateUsuarioCliente(@Validated @RequestBody ClienteDTO dto) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new BadRequestException("Id inexistente");
        }
        ClienteDTO result = clienteService.update(dto);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuarioCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
	


}
