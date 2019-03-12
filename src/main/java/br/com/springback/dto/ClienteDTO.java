package br.com.springback.dto;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.springback.utils.ValidaCPF;
import br.com.springback.utils.ValidaEmail;
import br.com.springback.utils.ValidaTelefone;
import lombok.Getter;
import lombok.Setter;

public class ClienteDTO {

	
	@Getter
	@Setter
    private Long id;
	
	@NotEmpty(message = "Nome não informado")
    @Size(min=3,max=100,message="Campo Nome: Limite de caracteres excedido - minimo 3 e máximo 60")
	@Getter
	@Setter
    private String nome;
    
	@NotEmpty(message = "CPF não informado")
	@Getter
	private String cpf;
    

	@Getter
	@Setter
	private EnderecoDTO endereco;
    
	@NotEmpty(message = "Informe pelo menos um telefone")
	@Getter
	@Setter
    private Set<TelefoneDTO> telefones;
    
	@NotEmpty(message = "Informe pelo menos um e-mail")
	@Getter
	@Setter
	private Set<EmailDTO> emails;
	
    
    public void setCpf(String cpf) {
    	this.cpf = cpf.replaceAll("[^0-9]", "");
	}
    
    @JsonIgnore
	String errors;

    @JsonIgnore
	public String validate() {
    	errors ="";
		if(!ValidaCPF.isCPF(cpf)) {
			errors = "CPF inválido";
		}
		emails.forEach(e -> 
		{
		 if(!ValidaEmail.isEmail(e.getEmail()))
					errors= "E-mail inválido";
		});
			
		telefones.forEach(e -> 
		{
			if(!ValidaTelefone.isTelefone(e.getNumero()))
					errors= "Telefone inválido";
		});	
		
		
		return errors;
	}

    
    

    
}