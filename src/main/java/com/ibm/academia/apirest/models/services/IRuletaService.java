package com.ibm.academia.apirest.models.services;

import java.util.List;
import java.util.Optional;

import com.ibm.academia.apirest.models.entitie.Ruleta;



public interface IRuletaService {
	
	public List<Ruleta> buscarTodos();
	public Optional<Ruleta> buscarPorId(Long productoId);

}
