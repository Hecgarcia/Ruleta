package com.ibm.academia.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.models.entitie.Ruleta;
import com.ibm.academia.apirest.services.IRuletaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/ruleta")
@Api(value = "Metodos relacionados a las Ruletas", tags = "Datos sobre Ruletas")
public class RuletaController {
	
	Logger logger = LoggerFactory.getLogger(RuletaController.class);
	
	@Autowired
	private IRuletaService ruletaService;
	
	/**
	 * EndPoint para listar las ruletas en la Base de datos
	 * @return lista de las ruletas
	 * @NotFoundException en caso de wue no haya ruletas en la bd
	 * @author Hector Garcia Espinobarro 21-12-2021 
	 */
	@ApiOperation(value = "consultar la lista de Ruletas")
	@ApiResponses({
		@ApiResponse(code = 200, message = "ejecutado exitosamente")
	})
	@GetMapping("/listar")
	public ResponseEntity<?> listarRuletas(){
		
		List<Ruleta> ruletas = ruletaService.buscarTodos();
		
		if(ruletas.isEmpty())
			throw new NotFoundException(" No existen Ruletas en la base de datos");
		
		return new ResponseEntity<List<Ruleta>>(ruletas, HttpStatus.OK);
	}
	
	
	
	/**
	 *EndPoint para obtener la ruleta por Id
	 * @return ruleta seleccionada por ID
	 * @NotFoundException en caso de que no exista ruleta
	 * @author Hector Garcia Espinobarro 21-12-2021 
	 */
	@ApiOperation(value = "Cunsultar ruleta por numero de lista")
	@ApiResponses({
		@ApiResponse(code = 200, message = "ejecutado exitosamente")
	})
	@GetMapping("/ruletaId/{ruletaId}")
	public ResponseEntity<?> buscarRuletaPorId(@PathVariable Long ruletaId) {
		
		Optional<Ruleta> ruleta = ruletaService.buscarPorId(ruletaId);
		
		if(ruleta.isPresent())
			throw new  NotFoundException(String.format("La ruleta con id: %d  no existe ", ruletaId));
		
		return new ResponseEntity<Ruleta> (ruleta.get(), HttpStatus.OK);		
	}

}
