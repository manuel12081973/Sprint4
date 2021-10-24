package com.misiontic.Sp4api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.Sp4api.entity.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

}
