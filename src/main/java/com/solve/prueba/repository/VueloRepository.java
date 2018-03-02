package com.solve.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solve.prueba.model.entities.Vuelo;

@Repository
public interface VueloRepository extends CrudRepository<Vuelo, Integer>{

}
