package br.com.springback.dto;

import javax.validation.constraints.NotEmpty;

import enums.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO {
	
		@Getter
		@Setter
        private Long id;
	
		@NotEmpty(message = "E-mail não informado")
	    private String email;
	    
	    
}
