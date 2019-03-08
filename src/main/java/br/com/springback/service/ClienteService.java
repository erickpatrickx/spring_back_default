package br.com.springback.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springback.domain.Cliente;
import br.com.springback.dto.ClienteDTO;
import br.com.springback.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
    @Autowired
    private ModelMapper modelMapper;
	

	public ClienteDTO save(ClienteDTO dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
	    repository.save(cliente);
	    modelMapper.map(cliente, dto);
	    return dto;
	}

}
