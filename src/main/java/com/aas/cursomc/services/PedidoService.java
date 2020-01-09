package com.aas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aas.cursomc.domain.Pedido;
import com.aas.cursomc.repositories.PedidoRepository;
import com.aas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;	
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		/*if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id
					+", Tipo: "+ Pedido.class.getName());			
		}*/
		
		//Expressão Lambda onde a função não recebe argumento e retorna a instância da expressão.
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+ Pedido.class.getName()));
	}
}
