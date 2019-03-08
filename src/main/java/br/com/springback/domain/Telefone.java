package br.com.springback.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import enums.TipoTelefone;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
public class Telefone {
	
	    @Id
	    @GeneratedValue
	    @Getter
	    private Long id;
	
	    @Column(nullable = false, unique = true)
	    @NotNull
	    @Getter
	    @Setter
	    private String numero;
	
	    @Column(nullable = false, unique = true)
	    @NotNull
	    @Enumerated(EnumType.ORDINAL)
	    @Getter
	    @Setter
	    private TipoTelefone tipoTelefone;
	    
		@ManyToOne(targetEntity=Cliente.class)
	    @Getter
	    @Setter
		private Cliente cliente;
		
	    
}
