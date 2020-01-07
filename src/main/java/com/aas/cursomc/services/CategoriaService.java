package com.aas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aas.cursomc.domain.Categoria;
import com.aas.cursomc.repositories.CategoriaRepository;
import com.aas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;	
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		/*if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id
					+", Tipo: "+ Categoria.class.getName());			
		}*/
		
		//Expressão Lambda onde a função não recebe argumento e retorna a instância da expressão.
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+ Categoria.class.getName()));
	}
}
