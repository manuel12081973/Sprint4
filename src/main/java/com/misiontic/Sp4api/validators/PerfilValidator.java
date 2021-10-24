package com.misiontic.Sp4api.validators;

import com.misiontic.Sp4api.entity.Perfil;

public class PerfilValidator {

	public static void save (Perfil perfil) {
		if (perfil.getNombre() == null || perfil.getNombre().trim().isEmpty()) {
			throw new RuntimeException("El nombre del perfil es obligatorio.");
		}
		if (perfil.getNombre().length() > 100) {
			throw new RuntimeException("El nombre del perfil es muy extenso, maximo 100 caracteres.");
		}
		
		if (perfil.getAutor() == null || perfil.getAutor().trim().isEmpty()) {
			throw new RuntimeException("El nombre del autor es obligatorio.");
		}
		if (perfil.getAutor().length() > 600) {
			throw new RuntimeException("El nombre del autor es muy extenso, maximo 600 caracteres.");
		}
		
	}
}
