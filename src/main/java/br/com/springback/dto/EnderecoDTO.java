package br.com.springback.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
public class EnderecoDTO {
	
		@NotEmpty(message = "CEP não informado")
	    private String cep;

		@NotEmpty(message = "Logradouro não informado")
		@Setter
		private String logradouro;
	    
		@NotEmpty(message = "Bairro não informado")
		@Setter
		private String bairro;
		
		@NotEmpty(message = "Cidade não informada")
		@Setter
		private String cidade;
		
		@NotEmpty(message = "UF não informado")
		@Size(min=2,max=2)
		@Setter
		private String uf;

		@Setter
		private String complemento;

		
	    public void setCep(String cep) {
	    	this.cep = cep.replaceAll("[^0-9]", "");
		}
	    
}
