package com.solve.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solve.prueba.model.entities.Vuelo;

@Repository
public interface VueloRepository extends CrudRepository<Vuelo, Integer>{

	@Query(value = "SELECT v FROM Vuelo v ")
	public List<Vuelo> consultarVuelos();
}
