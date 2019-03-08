package br.com.springback.dto;

import java.util.List;

import javax.validation.constraints.Null;

import lombok.Getter;

@Getter
public class ClienteDTO {

	
	@Null
    private String id;
    private String nome;
    private String cpf;
    private EnderecoDTO endereco;
    private List<TelefoneDTO> telefones;
    private List<EmailDTO> emails;

}