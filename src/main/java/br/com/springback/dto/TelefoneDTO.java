package br.com.springback.dto;
import javax.validation.constraints.NotEmpty;

import enums.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

public class TelefoneDTO {
		
		@Getter
		@Setter
		private Long id;
	
		@NotEmpty(message="Telefone não informado")
		@Getter
	    private String numero;
	   
		@Getter
		@Setter
		private TipoTelefone tipoTelefone;
		
		public void setNumero(String numero) {
			   this.numero = numero.replaceAll("[^0-9]", "");
		}
}
