package br.com.springback.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
public class Cliente extends EntidadeBase {
	
	
	    @Column(nullable = false)
	    @NotNull
	    @Getter
	    @Setter
	    @Size(min=3,max=100)
	    private String nome;
	
	    @Column(nullable = false, unique = true)
	    @NotNull
	    @Getter
	    private String CPF;
	    
	    @OneToMany(mappedBy = "cliente", targetEntity = Email.class,cascade = CascadeType.ALL)
	    @Getter
	    @Setter
	    @NotEmpty
	    private List<Email> emails;
	    
	    @OneToMany(mappedBy = "cliente", targetEntity = Telefone.class,cascade = CascadeType.ALL)
	    @Getter
	    @Setter
	    private List<Telefone> telefones;
	    
		@Embedded
	    @NotNull
	    @Getter
	    @Setter
		private Endereco endereco;
	    
		
	    public void setTelefone(final String nome) {
	        this.nome = nome;
	    }
	    
	    public void setCpf(final String CPF) {
	        this.CPF = CPF;
	    }
	
}
