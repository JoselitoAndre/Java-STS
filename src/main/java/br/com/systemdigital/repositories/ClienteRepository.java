package br.com.systemdigital.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemdigital.domain.Cliente;;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	

}
