package br.com.systemdigital.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemdigital.domain.Cliente;
import br.com.systemdigital.repositories.ClienteRepository;
import br.com.systemdigital.services.exceptions.ObjectNotFoundException;

@Service 
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		/*Optional<Cliente> obj = repo.findById(id); 
		return obj.orElse(null);*/
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
