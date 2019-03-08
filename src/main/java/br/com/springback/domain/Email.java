package br.com.springback.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
public class Email {
	
	    @Id
	    @GeneratedValue
	    @Getter
	    private Long id;
	
	    @Column(nullable = false, unique = true)
	    @NotNull
	    @Getter
	    @Setter
	    private String email;
	
		@ManyToOne(targetEntity=Cliente.class)
	    @Getter
	    @Setter
		private Cliente cliente;
		
	    
}
