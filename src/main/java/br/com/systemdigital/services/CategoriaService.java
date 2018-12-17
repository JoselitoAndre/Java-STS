package br.com.systemdigital.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.systemdigital.domain.Categoria;
import br.com.systemdigital.repositories.CategoriaRepository;
import br.com.systemdigital.services.exceptions.DataIntegrityViolationExceptipn;
import br.com.systemdigital.services.exceptions.ObjectNotFoundException;

@Service 
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find (Integer id) {
		/*Optional<Categoria> obj = repo.findById(id); 
		return obj.orElse(null);*/
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationExceptipn("Não é possivel excluir uma categoria que possui produtos");
		}
	}
}
