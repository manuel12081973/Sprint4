package com.misiontic.Sp4api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.Sp4api.entity.Perfil;
import com.misiontic.Sp4api.repository.PerfilRepository;
import com.misiontic.Sp4api.validators.PerfilValidator;

@Service
public class PerfilService {

	@Autowired
    private PerfilRepository perfilRepo;
		
	public Perfil findById(Long perfilId) {
		Perfil perfil = perfilRepo.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));
		return perfil;
	}
	
	
	public List<Perfil> findAll(){
		List<Perfil> perfiles = perfilRepo.findAll();
		return perfiles;
	}
	
	@Transactional
	public Perfil create(Perfil perfil) {
		PerfilValidator.save(perfil);
		
		Perfil nuevoPerfil = perfilRepo.save(perfil);
		return nuevoPerfil;				
	}
	
	@Transactional
	public Perfil update(Perfil perfil) {
		PerfilValidator.save(perfil);
		
		Perfil existePerfil = perfilRepo.findById(perfil.getId())
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));	
		existePerfil.setNombre(perfil.getNombre());
		existePerfil.setAutor(perfil.getAutor());
		perfilRepo.save(existePerfil);
		return existePerfil;		
	}
	
	@Transactional
	public void delete (Long perfilId) {
		Perfil perfil = perfilRepo.findById(perfilId)
				.orElseThrow(() -> new RuntimeException("No existe el perfil."));
		perfilRepo.delete(perfil);		
	}
	
}
