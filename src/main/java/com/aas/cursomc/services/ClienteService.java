package com.aas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aas.cursomc.domain.Cliente;
import com.aas.cursomc.repositories.ClienteRepository;
import com.aas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;	
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		/*if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id
					+", Tipo: "+ Cliente.class.getName());			
		}*/
		
		//Expressão Lambda onde a função não recebe argumento e retorna a instância da expressão.
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+ Cliente.class.getName()));
	}
}
