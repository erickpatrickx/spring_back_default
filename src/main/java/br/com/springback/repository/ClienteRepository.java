package br.com.springback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springback.domain.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	    @Override
	    @Query("select cliente from Cliente cliente inner join fetch cliente.emails inner join fetch cliente.telefones")
	    List<Cliente> findAll();

	    
	    @Override
	    @Query("select  cliente from Cliente cliente inner join fetch cliente.emails inner join fetch cliente.telefones where cliente.id = ?1")
	    Optional<Cliente> findById(Long id);
	    
}
