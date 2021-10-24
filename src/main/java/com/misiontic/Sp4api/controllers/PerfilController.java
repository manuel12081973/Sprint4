package com.misiontic.Sp4api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.Sp4api.entity.Perfil;
import com.misiontic.Sp4api.services.PerfilService;

@RestController
public class PerfilController {
	
	@Autowired
    private PerfilService perfilService;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/libros/{perfilId}")
	public ResponseEntity<Perfil> findById(@PathVariable("perfilId") Long perfilId) {
		Perfil perfil = perfilService.findById(perfilId);				
		return new ResponseEntity<Perfil>(perfil, HttpStatus.OK );
	}
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/libros")
	public ResponseEntity<List<Perfil>> findAll(){
		List<Perfil> perfiles = perfilService.findAll();
		return new ResponseEntity<List<Perfil>>(perfiles, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/libros")
	public ResponseEntity<Perfil> create(@RequestBody Perfil perfil) {
		Perfil nuevoPerfil = perfilService.create(perfil);
		return new ResponseEntity<Perfil>(nuevoPerfil, HttpStatus.CREATED);
				
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/libros")
	public ResponseEntity<Perfil> update(@RequestBody Perfil perfil) {
		Perfil existePerfil = perfilService.update(perfil);
		return new ResponseEntity<Perfil>(existePerfil, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/libros/{perfilId}")
	public ResponseEntity<Void> delete(@PathVariable("perfilId") Long perfilId) {
		perfilService.delete(perfilId);
		return new ResponseEntity(HttpStatus.OK);
		
	}
}
