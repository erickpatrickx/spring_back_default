package br.com.springback.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Embeddable
@RequiredArgsConstructor
public class Endereco {
	
	    @Column(nullable = false)
	    @NotNull
	    @Getter
	    @Setter
	    @Size(min=8,max=8)
	    private String cep;
	
	
	    @Column(nullable = false)
	    @NotNull
	    @Getter
	    @Setter
	    private String logradouro;
	    
	    
	    @Column(nullable = false)
	    @NotNull
	    @Getter
	    @Setter
	    private String bairro;
	    
	    
	    @Column(nullable = false)
	    @NotNull
	    @Getter
	    @Setter
	    private String cidade;
	    
	    
	    @Column(nullable = false)
	    @NotNull
	    @Getter
	    @Setter
	    @Length(max=8,min=8)
	    private String uf;
	    
	    
	    @Column(nullable = true)
	    @NotNull
	    @Getter
	    @Setter
	    private String complemento;
	    
	    
	    
		
}
