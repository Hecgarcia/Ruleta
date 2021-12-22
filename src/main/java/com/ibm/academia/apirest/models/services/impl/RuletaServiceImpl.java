package com.ibm.academia.apirest.models.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.models.entitie.Ruleta;
import com.ibm.academia.apirest.models.repository.RuletaRepository;
import com.ibm.academia.apirest.models.services.IRuletaService;

@Service
public class RuletaServiceImpl implements IRuletaService {
	
	@Autowired
	private RuletaRepository ruletaRepository;

	@Override
	public List<Ruleta> buscarTodos() {
		
		return (List<Ruleta>) ruletaRepository.findAll();
	}

	@Override
	public Optional<Ruleta> buscarPorId(Long productoId) {
		
		return ruletaRepository.findById(productoId);
	}
	
}
