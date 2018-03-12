package com.solve.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solve.prueba.model.entities.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

//	@Query(value = "SELECT u FROM Usuario u WHERE u.cedula = :cedula ")
//	public Usuario consultarByCedula(@Param("cedula") String cedula);
	
	public Usuario findByCedula(String cedula);
	
}
