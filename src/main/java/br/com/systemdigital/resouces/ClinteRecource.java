package br.com.systemdigital.resouces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemdigital.domain.Cliente;
import br.com.systemdigital.services.ClienteService;

@RestController
@RequestMapping(value ="/clientes")
public class ClinteRecource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
