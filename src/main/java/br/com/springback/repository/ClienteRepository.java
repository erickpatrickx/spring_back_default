package br.com.springback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springback.domain.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
