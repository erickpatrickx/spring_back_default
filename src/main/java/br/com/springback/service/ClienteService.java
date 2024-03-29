package br.com.springback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springback.domain.Cliente;
import br.com.springback.domain.Email;
import br.com.springback.domain.Telefone;
import br.com.springback.dto.ClienteDTO;
import br.com.springback.dto.EmailDTO;
import br.com.springback.dto.TelefoneDTO;
import br.com.springback.exception.BusinessException;
import br.com.springback.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
    @Autowired
    private ModelMapper modelMapper;
	

	public ClienteDTO save(ClienteDTO dto){
		List errors = dto.validate();
		if(errors != null && errors.size() > 0) {
			throw new BusinessException(errors);
		}
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.getEmails().forEach(emails -> emails.setCliente(cliente));
		cliente.getTelefones().forEach(emails -> emails.setCliente(cliente));
	    repository.save(cliente);
	    modelMapper.map(cliente, dto);
	    return dto;
	}
	
	
	public ClienteDTO update(ClienteDTO dto) {
		List errors = dto.validate();
		if(errors != null && errors.size() > 0) {
			throw new BusinessException(errors);
		}
		Cliente cliente =repository.findById(dto.getId()).get();
		modelMapper.map(dto,cliente);
		cliente.getEmails().forEach(emails -> emails.setCliente(cliente));
		cliente.getTelefones().forEach(emails -> emails.setCliente(cliente));
		repository.save(cliente);
	    modelMapper.map(cliente, dto);
	    return dto;
	}

	public List<ClienteDTO> findAll() {
		List<ClienteDTO> dtos = repository.findAll().stream()
        .filter(Objects::nonNull)
        .map(this::toDTO)
        .collect(Collectors.toList());
		return dtos;
	}

	
	public ClienteDTO findById(Long id) {
		Optional<Cliente> entity = repository.findById(id);
		if(entity.isPresent()) {
			return toDTO(entity.get());
		}
		return null;
	}

	
	

    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        } else {
        	ClienteDTO clienteDTO = new ClienteDTO();
        	clienteDTO =  modelMapper.map(cliente, ClienteDTO.class);
    		return clienteDTO;
        }
    }
    
	public void copyListsUpdateEmail(Set<EmailDTO> dtos,final Set<Email> emails) {
		emails.clear();
		dtos.forEach(dto -> 
		{
			Email email =  modelMapper.map(dto, Email.class);
			emails.add(email);	
		});
	}
	
	public void copyListsUpdateTelefone(Set<TelefoneDTO> dtos,final Set<Telefone> telefones) {
		telefones.clear();
		dtos.forEach(dto -> 
		{
			Telefone telefone =  modelMapper.map(dto, Telefone.class);
			telefones.add(telefone);	
		});
	}
	
	
	
	public void delete(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		repository.delete(cliente.get());
	}

}
