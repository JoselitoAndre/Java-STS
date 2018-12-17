
package br.com.systemdigital.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemdigital.domain.Pedido;
import br.com.systemdigital.repositories.PedidoRepository;
import br.com.systemdigital.services.exceptions.ObjectNotFoundException;

@Service 
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		/*Optional<Pedido> obj = repo.findById(id); 
		return obj.orElse(null);*/
		
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
