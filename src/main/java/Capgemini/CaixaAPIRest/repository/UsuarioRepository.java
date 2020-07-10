package Capgemini.CaixaAPIRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Capgemini.CaixaAPIRest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//Usuario findById(long  id);
    Usuario findBycpf(String cpf);
    
	
}




//@Query("SELECT t.title FROM Todo t where t.id = :id") 
//Optional<String> findTitleById(@Param("id") Long id);
//@Query("SELECT t.title FROM Todo t where t.id = :id") 
//String findTitleById(@Param("id") Long id);
//https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction-to-query-methods/


