package Capgemini.CaixaAPIRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Capgemini.CaixaAPIRest.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	Conta findById(long id);
	
}
